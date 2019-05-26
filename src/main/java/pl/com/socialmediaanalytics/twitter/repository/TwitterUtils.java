package pl.com.socialmediaanalytics.twitter.repository;

import com.google.gson.Gson;
import pl.com.socialmediaanalytics.twitter.domain.Coordinates;
import pl.com.socialmediaanalytics.twitter.domain.StatusListenerImpl;
import twitter4j.*;
import twitter4j.TwitterResponse.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TwitterUtils {



    public static void streamFeed() {

        StatusListener listener = new StatusListenerImpl();

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        twitterStream.addListener(listener);
        //GeoLocation geoLocation = new GeoLocation(54.35774,18.62987);
        //Query.Unit unit = Query.KILOMETERS; // or Query.MILES;
        //query.setGeoCode(location, 10, unit);

        Coordinates coordinates = new Coordinates();
        FilterQuery filterLocation = new FilterQuery();
        filterLocation.locations(coordinates.getBoundingBox());

    }
}
