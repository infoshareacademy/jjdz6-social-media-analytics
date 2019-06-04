package pl.com.socialmediaanalytics.twitter.service;

import twitter4j.Location;
import twitter4j.RateLimitStatus;
import twitter4j.Trend;
import twitter4j.Trends;

import java.util.Date;

public class DateTrendLService  implements Trends {


    @Override
    public Trend[] getTrends() {
        return new Trend[0];
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public Date getAsOf() {
        return null;
    }

    @Override
    public Date getTrendAt() {
        return null;
    }

    @Override
    public int compareTo(Trends o) {
        return 0;
    }

    @Override
    public RateLimitStatus getRateLimitStatus() {
        return null;
    }

    @Override
    public int getAccessLevel() {
        return 0;
    }
}
