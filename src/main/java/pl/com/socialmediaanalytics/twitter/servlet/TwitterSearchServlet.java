package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.presentation.MediaEntityDTO;
import pl.com.socialmediaanalytics.twitter.presentation.OriginalStatusDTO;
import pl.com.socialmediaanalytics.twitter.presentation.TweetPresentationObjectDTO;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/tweet-search")

public class TwitterSearchServlet extends HttpServlet {

    @Inject
    TwitterSearchService twitterSearchService;

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "tweet-search.ftlh");

        resp.setContentType("text/html;charset=UTF-8");


        model.put("currentDate", LocalDate.now());
        model.put("tweets", null);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String optionParam = req.getParameter("option");
        String textParam = req.getParameter("text");
        String langParam = req.getParameter("lang");
        String dateParam = req.getParameter("date");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "tweet-search.ftlh");
        model.put("currentDate", LocalDate.now());

        if(optionParam == null || optionParam.isEmpty() || textParam == null && textParam.isEmpty()
                || langParam == null|| langParam.isEmpty() || dateParam == null || dateParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.println("<H1>" + resp.getStatus() + "- BAD REQUEST!</H1>");
            return;
        } else {
            model.put("option", optionParam);
            model.put("text", textParam);
            model.put("lang", langParam);
            model.put("date", dateParam);
        }

        if(!Arrays.asList(Locale.getISOLanguages()).contains(langParam)) {
            System.out.println("Podano niepoprawny kod języka. Podaj właściwy kod języka według ISO 639-1."
                    + "Kody możesz sprawdzić <a href=\"https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes\">Tutaj</a>");
        }

        //IP usera, posłuży do logowania statystyk
        String ip = req.getRemoteAddr();

        List<Status> statuses = new ArrayList<>();

        try {
                statuses = twitterSearchService.searchTweets(textParam, LocalDate.parse(dateParam).toString(), langParam, optionParam);
            } catch (TwitterException e) {
                model.put("errorMessage", e.getErrorMessage());
//            System.out.println(
//                    "Error message: " + e.getErrorMessage()
//                    + "Access level:  " + e.getAccessLevel()
//                    + "Exception code: " + e.getExceptionCode()
//                    + "Error code: " + e.getErrorCode()
//                    + "Exceeded rate limitation: " + e.exceededRateLimitation()
//                    + "Rate limit- limit: " + e.getRateLimitStatus().getLimit()
//                    + "Rate limit- remaining" + e.getRateLimitStatus().getRemaining()
//                    + "Retry after: " + e.getRetryAfter() + " " + e.getStatusCode() +  " " + e.getClass().getCanonicalName()
            //);
        }

        List<TweetPresentationObjectDTO> tweets = new ArrayList<>();

        if(statuses.isEmpty()) {
            model.put("errorMessage","Nie znaleziono wyników dla podanych kryteriów. Spróbuj innych kryteriów.");
        }

        for (Status status : statuses) {
            System.out.println();
            OriginalStatusDTO originalStatusDTO = new OriginalStatusDTO();
            List<MediaEntityDTO> mediaURLList = new ArrayList<>();
            List<String> hashtagList = new ArrayList<>();
            List<String> urlList =new ArrayList<>();

            for(HashtagEntity hashtagEntity : status.getHashtagEntities()){
               hashtagList.add(hashtagEntity.getText());
            }

            for(MediaEntity mediaEntity : status.getMediaEntities()) {
                if(mediaEntity.getType().equals("video")) {
                    Map<Integer, String> variantsMap = Arrays.stream(mediaEntity.getVideoVariants())
                            .collect(Collectors.toMap(MediaEntity.Variant::getBitrate,MediaEntity.Variant::getUrl));

                    String mediaUrl = variantsMap.entrySet().stream()
                            .max(Map.Entry.comparingByKey()).get().getValue();

                    mediaURLList.add(new MediaEntityDTO(mediaUrl, "video"));
                    System.out.println(mediaUrl);
                } else {
                    mediaURLList.add(new MediaEntityDTO(mediaEntity.getMediaURL(), "image"));
                }
            }

            for(URLEntity urlEntity : status.getURLEntities()) {
                urlList.add(urlEntity.getExpandedURL());
            }

            if(status.getRetweetedStatus() != null){
                List<MediaEntityDTO> retweetedMediaURLList = new ArrayList<>();
                List<String> retweetedHashtagList = new ArrayList<>();
                List<String> retweetedUrlList =new ArrayList<>();

                for(HashtagEntity retweetedHashtagEntity : status.getRetweetedStatus().getHashtagEntities()){
                    retweetedHashtagList.add(retweetedHashtagEntity.getText());
                }
                for(MediaEntity retweetedMediaEntity : status.getRetweetedStatus().getMediaEntities()) {
                    if(retweetedMediaEntity.getType().equals("video")) {
                        Map<Integer, String> variantsMap = Arrays.stream(retweetedMediaEntity.getVideoVariants())
                                .collect(Collectors.toMap(MediaEntity.Variant::getBitrate,MediaEntity.Variant::getUrl));

                        String mediaUrl = variantsMap.entrySet().stream()
                                .max(Map.Entry.comparingByKey()).get().getValue();

                        mediaURLList.add(new MediaEntityDTO(mediaUrl, "video"));

                    } else {
                        mediaURLList.add(new MediaEntityDTO(retweetedMediaEntity.getMediaURL(), "image"));
                    }

                    System.out.println(retweetedMediaEntity.getType() + " " + retweetedMediaEntity.getMediaURL());
                }
                for(URLEntity retweetedUrlEntity : status.getRetweetedStatus().getURLEntities()) {
                    retweetedUrlList.add(retweetedUrlEntity.getExpandedURL());

                }
                originalStatusDTO = new OriginalStatusDTO(
                        status.getRetweetedStatus().getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        status.getRetweetedStatus().getUser().getName(),
                        status.getRetweetedStatus().getUser().getName(),
                        status.getUser().getProfileImageURL(),
                        status.getRetweetedStatus().getText(),
                        Integer.valueOf(status.getRetweetedStatus().getFavoriteCount()),
                        Integer.valueOf(status.getRetweetedStatus().getRetweetCount()),
                        retweetedMediaURLList,
                        retweetedHashtagList,
                        retweetedUrlList);
            }

            if(status.getQuotedStatus() != null) {
                List<MediaEntityDTO> retweetedMediaURLList = new ArrayList<>();
                List<String> retweetedHashtagList = new ArrayList<>();
                List<String> retweetedUrlList =new ArrayList<>();

                for(HashtagEntity retweetedHashtagEntity : status.getQuotedStatus().getHashtagEntities()){
                    retweetedHashtagList.add(retweetedHashtagEntity.getText());
                }
                for(MediaEntity retweetedMediaEntity : status.getQuotedStatus().getMediaEntities()) {
                    if(retweetedMediaEntity.getType().equals("video")) {
                        Map<Integer, String> variantsMap = Arrays.stream(retweetedMediaEntity.getVideoVariants())
                                .collect(Collectors.toMap(MediaEntity.Variant::getBitrate,MediaEntity.Variant::getUrl));

                        String mediaUrl = variantsMap.entrySet().stream()
                                .max(Map.Entry.comparingByKey()).get().getValue();

                        mediaURLList.add(new MediaEntityDTO(mediaUrl, "video"));

                    } else {
                        mediaURLList.add(new MediaEntityDTO(retweetedMediaEntity.getMediaURL(), "image"));
                    }
                }

            for(URLEntity retweetedUrlEntity : status.getQuotedStatus().getURLEntities()) {
                retweetedUrlList.add(retweetedUrlEntity.getExpandedURL());
            }
            originalStatusDTO = new OriginalStatusDTO(
                    status.getQuotedStatus().getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    status.getQuotedStatus().getUser().getName(),
                    status.getQuotedStatus().getUser().getName(),
                    status.getUser().getProfileImageURL(),
                    status.getQuotedStatus().getText(),
                    Integer.valueOf(status.getQuotedStatus().getFavoriteCount()),
                    Integer.valueOf(status.getQuotedStatus().getRetweetCount()),
                    retweetedMediaURLList,
                    retweetedHashtagList,
                    retweetedUrlList);
        }

            tweets.add(new TweetPresentationObjectDTO(
                    status.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    status.getUser().getName(),
                    status.getUser().getScreenName(),
                    status.getUser().getBiggerProfileImageURL(),
                    status.getText(),
                    Integer.valueOf(status.getFavoriteCount()),
                    Integer.valueOf(status.getRetweetCount()),
                    mediaURLList,
                    hashtagList,
                    urlList,
                    originalStatusDTO
            ));
        }

        model.put("tweets", tweets);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            System.out.println(e.getMessage() + e.getClass().getCanonicalName());
        }
    }
}
