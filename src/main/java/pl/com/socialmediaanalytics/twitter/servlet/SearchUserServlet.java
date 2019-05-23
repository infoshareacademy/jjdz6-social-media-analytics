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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String>statusList = new ArrayList<>();
        List<String>userImage = new ArrayList<>();

       String searchUser = req.getParameter("user");
        Twitter twitter = twitterInstance.getTwitterInstance();
        PrintWriter p = resp.getWriter();
        try {
            ResponseList<User> users;
            int page = 1;
            do {
                users = twitter.searchUsers(searchUser,page);
                for (User user : users) {
                    if (user.getStatus() != null) {
                       userImage.add(user.getBiggerProfileImageURL());
                        statusList.add(user.getName());
                        statusList.add(user.getStatus().getText());

                    } else {
                    }
                }
                page++;
            } while (users.size() != 0 && page < 5);

        } catch (TwitterException te) {
            te.printStackTrace();
        }

        Template template = templateProvider.getTemplate(getServletContext(),"user.ftlh");
        Map<String,List<String>>model = new HashMap<>();
        model.put("users",statusList);
        model.put("userImage",userImage);

        try {
            template.process(model,p);
        }catch (TemplateException e){
            e.printStackTrace();
        }

    }
}
