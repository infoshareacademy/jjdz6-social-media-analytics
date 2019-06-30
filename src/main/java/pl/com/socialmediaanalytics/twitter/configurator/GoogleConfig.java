package pl.com.socialmediaanalytics.twitter.configurator;


import com.google.maps.GeoApiContext;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GoogleConfig {

    private GeoApiContext geoApiContext;


    @PostConstruct
    public void createContex() {

        geoApiContext = new GeoApiContext.Builder()
                .apiKey("AIzaSyB7PCQggzOtF1cQbGw_Gfho06NLBApfvBA")
                .build();
    }

    public GeoApiContext getGeoApiContext() {
        return geoApiContext;
    }
}
