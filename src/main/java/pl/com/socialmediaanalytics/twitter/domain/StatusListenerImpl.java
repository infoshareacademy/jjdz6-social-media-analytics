package pl.com.socialmediaanalytics.twitter.domain;

import pl.com.socialmediaanalytics.twitter.dao.TweetRepositoryDao;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.TwitterObjectFactory;




public class StatusListenerImpl implements twitter4j.StatusListener {

    public String returnOnStatus(Status status) {
        String rawJSON = TwitterObjectFactory.getRawJSON(status);
        return rawJSON;
    }

    @Override
    public void onStatus(Status status) {

    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}
