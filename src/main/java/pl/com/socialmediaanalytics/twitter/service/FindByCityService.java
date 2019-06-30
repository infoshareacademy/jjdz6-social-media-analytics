package pl.com.socialmediaanalytics.twitter.service;


import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.dto.TrendDTO;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class FindByCityService {
    @Inject
    TwitterInstance twitterInstance;

    @Inject
    WoeidService woeidService;

    public List<TrendDTO> trendList(String name) {
        List<TrendDTO> trendDTOList = new ArrayList<>();
        Trends trends;
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            trends = twitter.getPlaceTrends(woeidService.weoid(name));
            for (Trend trend : trends.getTrends()) {
                trendDTOList.add(new TrendDTO(trend.getName(), trend.getQuery(), trend.getURL()));
            }

        } catch (TwitterException t) {
            t.printStackTrace();
        }
        return trendDTOList;

    }
}
