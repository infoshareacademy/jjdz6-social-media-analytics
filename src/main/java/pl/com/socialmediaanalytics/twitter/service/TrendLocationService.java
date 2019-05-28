package pl.com.socialmediaanalytics.twitter.service;

import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.enterprise.context.RequestScoped;
import java.util.*;

@RequestScoped
public class TrendLocationService {

    private TwitterInstance twitterInstance = new TwitterInstance();

    private List<String> NAME = new ArrayList<>();
    private List<Integer> WOEID = new ArrayList<>();
    private Map<String, Integer> NAME_WEOID = new LinkedHashMap<>();

    private void fillNAME() {
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<Location> locations = twitter.getAvailableTrends();
            for (Location location : locations) {
                NAME.add(location.getName());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }

    private void fillWEOID() {
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<Location> locations = twitter.getAvailableTrends();
            for (Location location : locations) {
                WOEID.add(location.getWoeid());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }

    public List<String> listNAME() {
        if (NAME.size() == 0) {
            fillNAME();
        }
        return NAME;
    }

    public List<Integer> listWEOID() {
        if (WOEID.size() == 0) {
            fillWEOID();
        }
        return WOEID;
    }

    public Map<String, Integer> name_weoid_map() {
        for (int i = 0; i < listWEOID().size(); i++) {
            NAME_WEOID.put(listNAME().get(i), listWEOID().get(i));
        }
        return NAME_WEOID;
    }
}
