package pl.com.socialmediaanalytics.twitter.mapper;

import pl.com.socialmediaanalytics.twitter.configurator.TemplateProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MapMapper {

    @Inject
    private TemplateProvider templateProvider;

}
