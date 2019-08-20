package pl.com.socialmediaanalytics.twitter.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.dto.TrendDTO;
import pl.com.socialmediaanalytics.twitter.model.Coordinates;
import pl.com.socialmediaanalytics.twitter.service.TrendMapService;
import pl.com.socialmediaanalytics.twitter.service.TrendTDOService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/map-trends")

public class MapTrendsServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    TrendTDOService trendTDOService;

    @Inject
    TrendMapService trendMapService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        final String param = req.getParameter("param");

        if (param == null || param.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }


        TrendDTO dt = trendTDOService.getTrendDTObyCoordinates(param);
        Coordinates coordinates = trendMapService.getCoordinates(param);


        Map<String, Object> model = new HashMap<>();
        model.put("trends", dt);
        model.put("coord", coordinates);


        Template template = templateProvider.getTemplate(getServletContext(), "map.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException te) {
            te.printStackTrace();
        }
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        model.put("lat", new Object());
        model.put("ln", new Object());
        model.put("trends", new Object());
        Template template = templateProvider.getTemplate(getServletContext(), "map.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException te) {
            te.printStackTrace();
        }
    }
}

