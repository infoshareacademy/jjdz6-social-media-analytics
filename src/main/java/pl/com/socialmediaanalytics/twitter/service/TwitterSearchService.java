package pl.com.socialmediaanalytics.twitter.service;

import twitter4j.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
public class TwitterSearchService {

    @Inject
    TwitterInstanceService twitterInstanceService;

    public List<Status> searchTweets(String userQuery) throws TwitterException {

        Integer numberOfResults = 1000;
        Twitter twitter = twitterInstanceService.getTwitterInstance();
        Query query = new Query(userQuery);
        //query.setCount(100);
        QueryResult result;

        List<Status> tweets = new ArrayList<>();

        while(tweets.size() < numberOfResults) {
            result = twitter.search(query);
            tweets.addAll(result.getTweets());
        }

        return tweets;
    }

     public List<Status> searchTweetsByDate(String userQuery, String date) throws TwitterException {

        Twitter twitter = twitterInstanceService.getTwitterInstance();
        Query query = new Query(userQuery);
        query.setUntil(date);
        query.setCount(100);
        QueryResult result = twitter.search(query);

        return result.getTweets();
    }




}
