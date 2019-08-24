package pl.com.socialmediaanalytics.twitter.dto;

public class UserDTO {

    private String name;
    private String status;

    private Integer followers;

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }


    public UserDTO(String name, String status, Integer followers) {
        this.name = name;
        this.status = status;
        this.followers = followers;
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

    public UserDTO(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public UserDTO(String name) {
        this.name = name;
    }
}
