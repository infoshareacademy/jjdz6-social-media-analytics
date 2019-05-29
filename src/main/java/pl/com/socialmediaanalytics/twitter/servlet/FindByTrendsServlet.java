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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> trendList = new ArrayList<>();
        List<String> trendListName = new ArrayList<>();
        Trends trends;
        String NAME = req.getParameter("NAME");
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
        PrintWriter writer = resp.getWriter();
        Map<String, List<String>> dateModel = new HashMap<>();
        dateModel.put("trendList", trendList);
        dateModel.put("trendListName", trendListName);
        Template template = templateProvider.getTemplate(getServletContext(), "trend.ftlh");

        try {
            template.process(dateModel, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}