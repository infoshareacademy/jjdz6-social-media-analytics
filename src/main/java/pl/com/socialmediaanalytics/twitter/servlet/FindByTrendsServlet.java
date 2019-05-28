package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.service.TwitterTrendService;
import twitter4j.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/find-trend")
public class FindByTrendsServlet extends HttpServlet {

    @Inject
    TwitterInstance twitterInstance;

    @Inject
    TemplateProvider templateProvider;

    @Inject
    TwitterTrendService twitterTrendService;


    private List<String> trendList = new ArrayList<>();
    private List<String> trendListName = new ArrayList<>();
    private Trends trends;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String NAME = req.getParameter("NAME");
        PrintWriter printWriter = resp.getWriter();

        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            trends = twitter.getPlaceTrends(twitterTrendService.WEOID(NAME));
            for (Trend trend : trends.getTrends()) {
                trendList.add(trend.getURL());
                trendListName.add(trend.getName());
            }

        } catch (TwitterException twitterException) {
            twitterException.printStackTrace();

        }

        Map<String, List<String>> dateModel = new HashMap<>();
        dateModel.put("trendList", trendList);
        dateModel.put("trendListName", trendListName);
        Template template = templateProvider.getTemplate(getServletContext(), "trend.ftlh");

        try {
            template.process(dateModel, printWriter);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}