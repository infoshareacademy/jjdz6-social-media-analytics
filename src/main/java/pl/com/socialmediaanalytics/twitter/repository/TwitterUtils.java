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

    public static Twitter getTwitterInstance() {

        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        return twitter;

    }




    public static List<String> searchtweets(String userQuery) throws TwitterException {
        Twitter twitter = getTwitterInstance();
        Query query = new Query(userQuery);
        QueryResult result = twitter.search(query);

        List<String> tweetList = new ArrayList<String>();
        result.getTweets();
        for (Status tweet : result.getTweets()) {
            String json = TwitterObjectFactory.getRawJSON(tweet);
            tweetList.add(json);
        }

        return tweetList;
    }

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
