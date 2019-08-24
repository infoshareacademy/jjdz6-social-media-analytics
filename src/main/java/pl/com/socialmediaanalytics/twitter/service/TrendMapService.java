package pl.com.socialmediaanalytics.twitter.service;


import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import pl.com.socialmediaanalytics.twitter.configurator.GoogleConfig;
import pl.com.socialmediaanalytics.twitter.model.Coordinates;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;

@RequestScoped
public class TrendMapService {

    @Inject
    GoogleConfig googleConfig;

    public Coordinates getCoordinates(String param) {
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(googleConfig.getGeoApiContext(),
                    param).await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        Double lat = results[0].geometry.location.lat;
        Double ln = results[0].geometry.location.lng;
        return new Coordinates(lat, ln);
    }
}