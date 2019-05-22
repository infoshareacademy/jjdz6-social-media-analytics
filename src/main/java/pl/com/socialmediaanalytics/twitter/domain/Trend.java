package pl.com.socialmediaanalytics.twitter.domain;

public class Trend  implements twitter4j.Trend {
    private String Name;
    private String URL;
    private String Query;

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public String getQuery() {
        return Query;
    }
}
