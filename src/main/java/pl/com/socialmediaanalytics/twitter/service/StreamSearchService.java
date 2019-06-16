package pl.com.socialmediaanalytics.twitter.service;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@RequestScoped
public class StreamSearchService {


    public static void streamFeed() {
//
        StatusListenerService listener = new StatusListenerService();
//
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
//
        twitterStream.addListener(listener);
//
//        Coordinates coordinates = new Coordinates();
//
//
      //  FilterQuery filterQuery = new FilterQuery();
    //    filterQuery.;

  //      twitterStream.


//
//
//        twitterStream.sample();
//        //twitterStream.filter(filterLocation);
//        //twitterStream.shutdown();
//
//    }
    }
}
