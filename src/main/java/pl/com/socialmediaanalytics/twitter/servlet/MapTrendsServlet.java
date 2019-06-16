package pl.com.socialmediaanalytics.twitter.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.dto.TrendDTO;
import twitter4j.*;

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
    TwitterInstance twitterInstance;

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyB7PCQggzOtF1cQbGw_Gfho06NLBApfvBA")
                .build();
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context,
                    req.getParameter("place")).await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].geometry.location));

        Double lat = results[0].geometry.location.lat;
        Double ln = results[0].geometry.location.lng;
        Map<String, Object> model = new HashMap<>();
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<Location> locations = twitter.getClosestTrends(new GeoLocation(lat, ln));
            Location loc = locations.get(0);
            Trends trends = twitter.getPlaceTrends(loc.getWoeid());
            for (Trend trend : trends.getTrends()) {
                TrendDTO td = new TrendDTO(trend.getName(), trend.getQuery(), trend.getURL());
                model.put("lat", results[0].geometry.location.lat);
                model.put("ln", results[0].geometry.location.lng);
                model.put("trends", td);
            }
        } catch (TwitterException e) {
            e.printStackTrace();

        }

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
        model.put("lat",new Object());
        model.put("ln",new Object());
        model.put("trends",new Object());
        Template template = templateProvider.getTemplate(getServletContext(), "map.ftlh");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException te) {
            te.printStackTrace();
        }
    }
}

