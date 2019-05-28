package pl.com.socialmediaanalytics.twitter.service;

import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import twitter4j.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.*;

@RequestScoped
public class TwitterTrendService {

    @Inject
    TwitterInstance twitterInstance;

    private TrendLocationService trendLocationService = new TrendLocationService();


    String NAME = "Oslo";

   public Integer WEOID () {
      if (trendLocationService.name_weoid_map().containsKey(NAME)){
          return trendLocationService.name_weoid_map().get(NAME);
      }
      return 0;
   }


}