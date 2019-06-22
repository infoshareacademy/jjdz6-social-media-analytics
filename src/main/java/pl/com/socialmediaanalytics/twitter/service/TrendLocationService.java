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

    private List<String> nameList = new ArrayList<>();
    private List<Integer> woeidList = new ArrayList<>();
    private Map<String, Integer> name_woeid = new LinkedHashMap<>();

    private void fillNameList() {
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<Location> locations = twitter.getAvailableTrends();
            for (Location location : locations) {
                nameList.add(location.getName());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }

    private void fillWoeidList() {
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<Location> locations = twitter.getAvailableTrends();
            for (Location location : locations) {
                woeidList.add(location.getWoeid());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }

    public List<String> listName() {
        if (nameList.size() == 0) {
            fillNameList();
        }
        return nameList;
    }

    public List<Integer> listWoeid() {
        if (woeidList.size() == 0) {
            fillWoeidList();
        }
        return woeidList;
    }

    public Map<String, Integer> name_weoid_map() {
        for (int i = 0; i < listWoeid().size(); i++) {
            name_woeid.put(listName().get(i), listWoeid().get(i));
        }
        return name_woeid;
    }
}
