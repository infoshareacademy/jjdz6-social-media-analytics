package pl.com.socialmediaanalytics.twitter.repository;

import pl.com.socialmediaanalytics.twitter.domain.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetRepository {

    private static List<Tweet> tweetRepository = new ArrayList<>();

    public static List<Tweet> getTweetRepository() {
        return tweetRepository;
    }

    public static void addTweet(Tweet tweet) {
        tweetRepository.add(tweet);
    }
}
