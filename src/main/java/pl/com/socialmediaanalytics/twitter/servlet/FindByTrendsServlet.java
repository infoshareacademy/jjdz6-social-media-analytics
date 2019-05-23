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

    private Trends trends;
    private List<String> trendList = new ArrayList<>();
    private List<String> trendListName = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> NAME = new ArrayList<>();
        List<Integer> WOEID = new ArrayList<>();

        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<Location> locations = twitter.getAvailableTrends();
            for (Location location : locations) {
                if (location.getWoeid() == 493417){
                    WOEID.add(location.getWoeid());
                }
                NAME.add(location.getName());

            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }
        for (Integer o:WOEID) {
            try {
                Twitter twitter = twitterInstance.getTwitterInstance();
                trends = twitter.getPlaceTrends(o);
                for (Trend trend : trends.getTrends()) {
                    trendList.add(trend.getURL());
                    trendListName.add(trend.getName());
                }

            } catch (TwitterException te) {
                te.printStackTrace();

            }
        }

        PrintWriter printWriter = resp.getWriter();


        Map<String,List<Integer>>dataModelSecond = new HashMap<>();
        dataModelSecond.put("weoids",WOEID);
        Map<String, List<String>> dateModel = new HashMap<>();
        dateModel.put("locations",NAME);
        dateModel.put("trendList", trendList);
        dateModel.put("trendListName", trendListName);
        Template template = templateProvider.getTemplate(getServletContext(), "trend.ftlh");
        try {
            template.process(dateModel, printWriter);
            template.process(dataModelSecond,printWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}