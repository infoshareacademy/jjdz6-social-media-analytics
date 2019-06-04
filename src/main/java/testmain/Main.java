package testmain;


import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import twitter4j.*;
import twitter4j.api.TrendsResources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws TwitterException {

        Twitter twitter = new TwitterFactory().getInstance();
        Trends trendPlace = twitter.getPlaceTrends(493417);
        List<Trends> list = new ArrayList<>();
        list.add(trendPlace);
        

        // Print the trends.
        for (Trends trends : list) {
            System.out.println("As of : " + trends.getAsOf());

            System.out.println(" " + trends.getTrendAt());
        }
    }

}

