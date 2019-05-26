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

    public List<String> searchtweets(String userQuery) throws TwitterException {
        Twitter twitter = twitterInstanceService.getTwitterInstance();
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


}
