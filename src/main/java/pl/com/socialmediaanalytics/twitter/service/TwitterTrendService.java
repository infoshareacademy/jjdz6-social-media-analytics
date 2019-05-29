package pl.com.socialmediaanalytics.twitter.service;



import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


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