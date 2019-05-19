package pl.com.socialmediaanalytics.twitter.dao;

import pl.com.socialmediaanalytics.twitter.domain.Tweet;
import pl.com.socialmediaanalytics.twitter.repository.TweetRepository;
import javax.ejb.Stateless;


@Stateless
public class TweetRepositoryDaoBean implements TweetRepositoryDao{

    @Override
    public void addTweet(Tweet tweet) {

        TweetRepository.getTweetRepository().add(tweet);

    }


}
