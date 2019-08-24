package pl.com.socialmediaanalytics.twitter.service;

import com.google.gson.Gson;
import pl.com.socialmediaanalytics.twitter.presentation.TweetPresentationObjectDTO;
import twitter4j.Status;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class JsonParserService {
    private Gson gson = new Gson();

    public String toJson(List<Status> tweets) {
        return gson.toJson(tweets);
    }
}
