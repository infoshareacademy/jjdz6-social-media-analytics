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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@WebServlet("/map-trends")

public class MapTrendsServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private TrendTDOService trendTDOService;

    @Inject
    private TrendMapService trendMapService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String place = req.getParameter("place");
        Cookie cookie = new Cookie("find-by-map", place);
        cookie.setMaxAge(60);
        resp.addCookie(cookie);


        TrendDTO dt = trendTDOService.getTrendDTObyCoordinates(place);
        Coordinates coordinates = trendMapService.getCoordinates(place);


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
        resp.setCharacterEncoding("UTF-8");
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

