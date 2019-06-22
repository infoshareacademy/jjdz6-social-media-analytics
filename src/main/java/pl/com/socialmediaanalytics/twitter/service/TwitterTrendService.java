package pl.com.socialmediaanalytics.twitter.service;



import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@RequestScoped
public class TwitterTrendService  {
    @Inject
    TrendLocationService trendLocationService;
    public Integer weoid(String name) {
        if (trendLocationService.name_weoid_map().containsKey(name)) {
            return trendLocationService.name_weoid_map().get(name);
        }
        return 0;
    }
}