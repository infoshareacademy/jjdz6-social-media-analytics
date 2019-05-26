package pl.com.socialmediaanalytics.twitter.domain;
import com.google.gson.Gson;
import pl.com.socialmediaanalytics.twitter.domain.Tweet;

public class Json2TweetParser {

    private static Gson gson;

    public static Tweet parseJson2Object(String json){
        Tweet tweet = gson.fromJson(json, Tweet.class);
        return tweet;
    }

}
