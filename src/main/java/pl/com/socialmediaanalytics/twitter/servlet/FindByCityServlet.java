package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.dto.TrendDTO;
import pl.com.socialmediaanalytics.twitter.service.FindByCityService;
import pl.com.socialmediaanalytics.twitter.service.WoeidService;
import twitter4j.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/find-trend")
public class FindByCityServlet extends HttpServlet {

    @Inject
    FindByCityService findByCityService;

    @Inject
    TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, List<String>> dateModel = new HashMap<>();
        dateModel.put("trendList", Collections.emptyList());
        Template template = templateProvider.getTemplate(getServletContext(), "trend.ftlh");
        try {
            template.process(dateModel, resp.getWriter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String param =req.getParameter("param");

        if (param == null || param.isEmpty() ) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

            List<TrendDTO> trendDTOList = findByCityService.trendList(param);
            Map<String, List<TrendDTO>> model = new HashMap<>();
            model.put("trendList", trendDTOList);

            Template template = templateProvider.getTemplate(getServletContext(), "trend.ftlh");

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }
