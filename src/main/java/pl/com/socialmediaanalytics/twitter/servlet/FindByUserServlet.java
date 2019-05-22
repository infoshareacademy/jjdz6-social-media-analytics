package pl.com.socialmediaanalytics.twitter.servlet;

import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
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
import java.util.List;

@WebServlet("/find-user")
public class FindByUserServlet extends HttpServlet {
    @Inject
    TwitterInstance twitterInstance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        String userParam = req.getParameter("user");
        Twitter twitter = twitterInstance.getTwitterInstance();

        try {
            User user = twitter.showUser(userParam);


        } catch (TwitterException te) {
            te.printStackTrace();
            printWriter.print("Failed to delete status: " + te.getMessage());

        }
    }
}


