package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
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
    TemplateProvider templateProvider;
    @Inject
    TwitterInstance twitterInstance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> trendList = new ArrayList<>();
        List<String>trendListName = new ArrayList<>();
        PrintWriter printWriter = resp.getWriter();

        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            Trends trends = twitter.getPlaceTrends(493417);


            for (Trend trend: trends.getTrends()) {
                String url = trend.getURL();
                trendList.add(url);
                trendListName.add(trend.getName());

            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }

        Map<String, List<String>> dateModel = new HashMap<>();
        dateModel.put("trendList", trendList);
        dateModel.put("trendListName",trendListName);
        Template template = templateProvider.getTemplate(getServletContext(), "trend.ftlh");
        try {
            template.process(dateModel, printWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}