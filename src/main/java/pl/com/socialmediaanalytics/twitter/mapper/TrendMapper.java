package pl.com.socialmediaanalytics.twitter.mapper;

import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;
import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.service.WoeidService;

import javax.inject.Inject;

public class TrendMapper {
    @Inject
    TemplateProvider templateProvider;

    @Inject
    TwitterInstance twitterInstance;

    @Inject
    WoeidService woeidService;



}
