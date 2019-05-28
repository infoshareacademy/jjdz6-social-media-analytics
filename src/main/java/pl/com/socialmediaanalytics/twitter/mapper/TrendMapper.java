package pl.com.socialmediaanalytics.twitter.mapper;

import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.service.TwitterTrendService;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrendMapper {
    @Inject
    TemplateProvider templateProvider;

    @Inject
    TwitterInstance twitterInstance;

    @Inject
    TwitterTrendService twitterTrendService;

    private List<String> trendList = new ArrayList<>();
    private List<String> trendListName = new ArrayList<>();

    private Trends trends;

    public void ListOfTrend() {
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            trends = twitter.getPlaceTrends(twitterTrendService.WEOID());
            for (Trend trend : trends.getTrends()) {
                trendList.add(trend.getURL());
                trendListName.add(trend.getName());
            }

        } catch (TwitterException twitterException) {
            twitterException.printStackTrace();

        }
    }

}
