package pl.com.socialmediaanalytics.twitter.servlet;

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
import java.util.List;

@WebServlet("search")
public class SearchTweet extends HttpServlet {

    @Inject
    TwitterInstance twitterInstance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lang = req.getParameter("lang");

        PrintWriter out = resp.getWriter();
        Twitter twitter = twitterInstance.getTwitterInstance();
        try {
            Query query = new Query(lang);
            QueryResult result= twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                   out.print("@" + tweet.getUser().getScreenName());
                }


        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}