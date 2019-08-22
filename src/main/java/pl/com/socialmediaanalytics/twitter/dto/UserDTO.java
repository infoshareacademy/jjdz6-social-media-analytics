package pl.com.socialmediaanalytics.twitter.dto;

public class UserDTO {

    private String name;
    private String status;
    private String imageURL;
    private Integer followers;

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public UserDTO(String name, String status, String imageURL, Integer followers) {
        this.name = name;
        this.status = status;
        this.imageURL = imageURL;
        this.followers= followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


}
