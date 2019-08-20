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
        resp.setCharacterEncoding("UTF-8");

        Map<String, Object> model = new HashMap<>();
        model.put("main", null);

        String googleUserName = (String) req.getSession().getAttribute("name");
        String email = (String) req.getSession().getAttribute("email");
        model.put("name", googleUserName);

        Cookie cookie = new Cookie("name",googleUserName);
        cookie.setMaxAge(120);
        resp.addCookie(cookie);

        Template template = templateProvider.getTemplate(getServletContext(), "main.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException te) {
            te.printStackTrace();
        }
    }
}
