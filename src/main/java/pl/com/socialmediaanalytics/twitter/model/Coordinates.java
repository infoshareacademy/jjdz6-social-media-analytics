package pl.com.socialmediaanalytics.twitter.model;

public class Coordinates {


    private Double lat;
    private Double ln;


    public Coordinates() {
    }

    public Coordinates(Double lat, Double ln) {
        this.lat = lat;
        this.ln = ln;
    }


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLn() {
        return ln;
    }

    public void setLn(Double ln) {
        this.ln = ln;
    }
}
