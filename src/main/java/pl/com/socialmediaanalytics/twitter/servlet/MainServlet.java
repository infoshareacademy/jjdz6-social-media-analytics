package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();
        String googleUserName = (String) req.getSession().getAttribute("name");
        model.put("name", googleUserName);

        String googleUserName = (String) req.getSession().getAttribute("google_name");
        String email = (String) req.getSession().getAttribute("email");
        model.put("google_name", googleUserName);



        Template template = templateProvider.getTemplate(getServletContext(), "main.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException te) {
            te.printStackTrace();
        }
    }

}
