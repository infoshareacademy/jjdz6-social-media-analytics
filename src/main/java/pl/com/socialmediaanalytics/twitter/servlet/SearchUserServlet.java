package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.service.SearchUserService;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search-user")
public class SearchUserServlet extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;
    @Inject
    TwitterInstance twitterInstance;

    @Inject
    SearchUserService searchUserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> statusList = new ArrayList<>();

        String userOne = req.getParameter("userOne");

        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<User> users;
            int page = 1;
            do {
                users = twitter.searchUsers(userOne, page);
                for (User user : users) {
                    if (user.getStatus() != null) {
                        statusList.add(user.getName());
                        statusList.add(user.getStatus().getText());

                    } else {
                    }
                }
                page++;
            } while (users.size() != 0 && page < 5);

        } catch (
                TwitterException te) {
            te.printStackTrace();
        }

        Map<String, List<String>> model = new HashMap<>();
        model.put("users", statusList);
        Template template = templateProvider.getTemplate(getServletContext(), "user.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
