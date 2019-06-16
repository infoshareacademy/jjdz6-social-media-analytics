package pl.com.socialmediaanalytics.twitter;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.freemarker.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.presentation.TweetPresentationObject;
import pl.com.socialmediaanalytics.twitter.service.TwitterSearchService;
import twitter4j.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/tweet-search")

public class TwitterSearchServlet extends HttpServlet {

    @Inject
    TwitterSearchService twitterSearchService;

    @Inject
    TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String optionParam = req.getParameter("option");
        String textParam = req.getParameter("text");
        PrintWriter writer = resp.getWriter();

        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "tweet-list.ftlh");

        List<Status> statuses = new ArrayList<>();

        try {

//            if((optionParam != null && !optionParam.isEmpty()) && (textParam != null && !textParam.isEmpty())) {
               if(optionParam == "lang") {
                  statuses = twitterSearchService.searchtweets("lang:" + "pl");
//               } else if(optionParam == "text") {
//                statuses = twitterSearchService.searchtweets("text:" + textParam);
//               } else if(optionParam == "city") {
//                    statuses = twitterSearchService.searchtweets("city:" + textParam);
//               }else if (optionParam == "country") {
//                    statuses = twitterSearchService.searchtweets("country:" + textParam);
//               }
//            } else {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                return;
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        List<TweetPresentationObject> tweets = new ArrayList<>();

        for (Status status : statuses) {
            List<String> mediaURLList = new ArrayList<>();
            List<String> hashtagList = new ArrayList<>();
            List<String> urlList =new ArrayList<>();

            for(HashtagEntity hashtagEntity : status.getHashtagEntities()){
                hashtagList.add(hashtagEntity.getText());
            }
            for(MediaEntity mediaEntity : status.getMediaEntities()) {
                mediaURLList.add(mediaEntity.getMediaURLHttps());
            }
            for(URLEntity urlEntity : status.getURLEntities()) {
                urlList.add(urlEntity.getDisplayURL());
            }
            tweets.add(new TweetPresentationObject(
                    status.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    status.getUser().getName(),
                    status.getUser().getScreenName(),
                    status.getUser().getBiggerProfileImageURL(),
                    status.getText(),
                    status.getSource(),
                    Integer.valueOf(status.getFavoriteCount()),
                    Integer.valueOf(status.getRetweetCount()),
                    mediaURLList,
                    hashtagList,
                    urlList
            ));
        }

        model.put("tweets", tweets);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
