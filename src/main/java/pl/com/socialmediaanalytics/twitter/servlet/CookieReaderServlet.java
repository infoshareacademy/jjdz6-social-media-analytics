package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cookie-reader")
public class CookieReaderServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();
        List<String> cookieList = new ArrayList<>();
        for (Cookie cookie1 : req.getCookies()) {
            cookieList.add(cookie1.getValue());

            model.put("cookies", cookieList);

            Template template = templateProvider.getTemplate(getServletContext(), "cookie.ftlh");
            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
    }
}
