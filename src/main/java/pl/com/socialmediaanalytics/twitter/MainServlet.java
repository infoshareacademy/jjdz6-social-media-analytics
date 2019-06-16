package pl.com.socialmediaanalytics.twitter;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.freemarker.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.presentation.TweetPresentationObject;
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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/main")
public class MainServlet extends HttpServlet {


        @Inject
        TemplateProvider templateProvider;


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            Map<String, Object> model = new HashMap<>();
            Template template = templateProvider.getTemplate(getServletContext(), "tweetSearchForm.ftlh");


            model.put("main", null);

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
   }


