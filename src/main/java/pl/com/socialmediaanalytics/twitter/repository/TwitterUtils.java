//package pl.com.socialmediaanalytics.twitter.repository;
//
//import com.google.gson.Gson;
//import pl.com.socialmediaanalytics.twitter.domain.Coordinates;
//import pl.com.socialmediaanalytics.twitter.service.StatusListenerService;
//import twitter4j.*;
//
//
//public class TwitterUtils {
//
//
//
//    public static void streamFeed() {
//
//        StatusListener listener = new StatusListenerService();
//
//        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
//
//        twitterStream.addListener(listener);
//        //GeoLocation geoLocation = new GeoLocation(54.35774,18.62987);
//        //Query.Unit unit = Query.KILOMETERS; // or Query.MILES;
//        //query.setGeoCode(location, 10, unit);
//
//        Coordinates coordinates = new Coordinates();
//        FilterQuery filterLocation = new FilterQuery();
//        filterLocation.locations(coordinates.getBoundingBox());
//
//    }
//}
