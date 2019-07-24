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
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;


@WebServlet ("/stream-map")

public class StreamMapTrendServlet extends HttpServlet {


    @Inject
    TemplateProvider templateProvider;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey("cSsvIzyZhzypbCoyaKk8f9y1D")
                .setOAuthConsumerSecret("5gUcBBhk1RXZRa3UOLHbgJhl7ry3tbkWaIN1sB1220LZUxAC6D")
                .setOAuthAccessToken("1099024186377453570-t6kKV6pykUO5v3Yuht3vVbnCHHKf4I")
                .setOAuthAccessTokenSecret("C5VAj1uOvymyAV09hGs7Fb8oPlRZs7s9OiIVn4uck4edq");

        TwitterStream twitterStream = new TwitterStreamFactory(configurationBuilder.build()).getInstance();


        StatusListener listener = new StatusListener() {
            public void onStatus(Status status) {

                Map<String, Object> model = new HashMap<>();
                model.put("stream",status.getText());

                try {
                    Template template = templateProvider.getTemplate(getServletContext(),"coord.ftlh");
                    template.process(model,resp.getWriter());
                } catch (IOException | TemplateException e) {
                    e.printStackTrace();
                }

            }
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
            }

            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
            }

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }

            public void onException(Exception ex) {
                ex.printStackTrace();
            }

        };




        twitterStream.addListener(listener);
        // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
        twitterStream.sample();

//
        FilterQuery filtro = new FilterQuery();
        double[][] bb= {{-180, -90}, {180, 90}};
        filtro.locations(bb);
        filtro.language(new String[]{"en"});
        twitterStream.filter(filtro);




    }
}










