//package pl.com.socialmediaanalytics.twitter.service;
//
//
//import pl.com.socialmediaanalytics.twitter.domain.Coordinates;
//import pl.com.socialmediaanalytics.twitter.domain.StatusListenerImpl;
//import twitter4j.*;
//
//import java.util.*;
//
//public class TwitterService {
//
//    public static Twitter getTwitterinstance() {
//
//        TwitterFactory tf = new TwitterFactory();
//        Twitter twitter = tf.getInstance();
//        return twitter;
//
//    }
//
//
//    public static List<String> searchtweets(String userQuery) throws TwitterException {
//        Twitter twitter = getTwitterinstance();
//        Query query = new Query(userQuery);
//        QueryResult result = twitter.search(query);
//        List<String> tweetList = new ArrayList<>();
//
//        result.getTweets();
//        for (Status tweet : result.getTweets()) {
//            String json = TwitterObjectFactory.getRawJSON(tweet);
//            tweetList.add(json);
//        }
//
//        return tweetList;
//    }
//
//    public static void streamFeed() {
//
//
//        StatusListenerImpl listener = new StatusListenerImpl();
//
//        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
//
//        twitterStream.addListener(listener);
//
//        Coordinates coordinates = new Coordinates();
//
//
//        FilterQuery filterLocation = new FilterQuery();
//        filterLocation.locations(coordinates.getBoundingBox());
//
//
//        twitterStream.sample();
//        //twitterStream.filter(filterLocation);
//        //twitterStream.shutdown();
//
//    }
//}
//
