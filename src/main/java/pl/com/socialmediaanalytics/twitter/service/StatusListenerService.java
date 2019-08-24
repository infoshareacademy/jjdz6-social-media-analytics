package pl.com.socialmediaanalytics.twitter.service;


import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class StatusListenerService implements twitter4j.StatusListener {

    List<Status> statuses;

    public StatusListenerService() {
        statuses = new ArrayList<>();
    }

    public List<Status> getStatuses(Status status) {

        return statuses;

    }

    @Override
    public void onStatus(Status status) {

        statuses.add(status);
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
