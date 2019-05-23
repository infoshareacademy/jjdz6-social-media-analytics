package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/find-user")
public class FindByUserServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    TwitterInstance twitterInstance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        String userParam = req.getParameter("user");
        Twitter twitter = twitterInstance.getTwitterInstance();


        try {

            User user = twitter.showUser(userParam);
            String statusText = user.getStatus().getText();
            Template template = templateProvider.getTemplate(getServletContext(), "user.ftlh");
            Map<String, String> model = new HashMap<>();
            model.put("user", statusText);
            template.process(model, printWriter);

        } catch (TwitterException te) {
            te.printStackTrace();

            printWriter.print("Failed to delete status: " + te.getMessage());

        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}


