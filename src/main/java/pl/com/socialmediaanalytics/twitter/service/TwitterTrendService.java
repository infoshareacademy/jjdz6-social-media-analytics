package pl.com.socialmediaanalytics.twitter.service;

import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import twitter4j.*;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;

@RequestScoped
public class TwitterTrendService  {


    @Inject
    TrendLocationService trendLocationService;


    public Integer WEOID(String NAME) {
        if (trendLocationService.name_weoid_map().containsKey(NAME)) {
            return trendLocationService.name_weoid_map().get(NAME);
        }
        return 0;
    }


}