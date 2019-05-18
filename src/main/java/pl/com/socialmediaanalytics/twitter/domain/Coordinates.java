package pl.com.socialmediaanalytics.twitter.domain;

public class Coordinates {
    private double[][] boundingBox;

    public Coordinates(){
        setBoundingBox();
    }

    public double[][] getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox() {
        //Gdańsk coordinates, for now hardcoded, but it will be changed
        boundingBox = new double[][]{{18.3804, 54.2721}, {18.7811, 54.4674}};
    }
}
