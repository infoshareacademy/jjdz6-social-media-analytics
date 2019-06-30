package pl.com.socialmediaanalytics.twitter.servlet;

import pl.com.socialmediaanalytics.twitter.service.TwitterSearchService;
import twitter4j.TwitterException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tweet-search")

public class TweetSerachServlet extends HttpServlet {

    @Inject
    TwitterSearchService twitterSearchService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String textParam = req.getParameter("lang");
        PrintWriter writer = resp.getWriter();

        if (textParam == null || textParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        List<String> tweetList = new ArrayList<>();
        try {
            tweetList = twitterSearchService.searchtweets("lang:" + textParam);
        } catch (TwitterException e) {
            e.printStackTrace();
        }


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        for (String tweet : tweetList) {
            out.print(tweet);
        }


    }
}
