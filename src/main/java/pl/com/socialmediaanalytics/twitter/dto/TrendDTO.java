package pl.com.socialmediaanalytics.twitter.dto;

public class TrendDTO {

    private String name;
    private String query;
    private String URL;

    public TrendDTO(String name, String query, String URL) {
        this.name = name;
        this.query = query;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
