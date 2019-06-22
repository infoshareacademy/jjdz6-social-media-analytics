package pl.com.socialmediaanalytics.twitter.service;

import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.dto.TrendDTO;
import pl.com.socialmediaanalytics.twitter.model.Coordinates;
import twitter4j.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TrendService {

    @Inject
    TwitterInstance twitterInstance;

    @Inject
    TrendMapService trendMapService;

    public TrendDTO  getTrendDTObyCoordinates(String param) {
        TrendDTO td = null;
        Coordinates coordinates = trendMapService.getCoordinates(param);
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            ResponseList<Location> locations = twitter.getClosestTrends(new GeoLocation(coordinates.getLat(), coordinates.getLn()));
            Location loc = locations.get(0);
            Trends trends = twitter.getPlaceTrends(loc.getWoeid());
            for (Trend trend : trends.getTrends()) {

               td = new TrendDTO(trend.getName(), trend.getQuery(), trend.getURL());
            }
        } catch (TwitterException e) {
            e.printStackTrace();

        }
        return td;
    }
}