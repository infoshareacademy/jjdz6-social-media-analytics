package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/search-user")
public class SearchUserServlet extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;
    @Inject
    TwitterInstance twitterInstance;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String us = req.getParameter("user");
        List<String> statusList = new ArrayList<>();
        List<String> imageURLlist = new ArrayList<>();
        Map<String, List<String>> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "user.ftlh");

        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            if (us != null && !us.equals("")) {
                ResponseList<User> users = twitter.searchUsers(us, 1);
                for (User user : users) {
                    statusList.add(user.getName());
                    statusList.add(user.getStatus().getText());
                    imageURLlist.add(user.getProfileImageURL());


                }
            }
            model.put("users", statusList);
            model.put("imagesUsers", imageURLlist);
            template.process(model, resp.getWriter());
        } catch (TwitterException | TemplateException e) {
            // LOG e
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, List<String>> model = new HashMap<>();
        model.put("users", Collections.emptyList());
        model.put("imagesUsers", Collections.emptyList());
        Template template = templateProvider.getTemplate(getServletContext(), "user.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            // LOG e
        }
    }
}




