package pl.com.socialmediaanalytics.twitter.domain;

public class User {
    Long id;
    String name;
    String screenName;
    String location;
    String description;
    Boolean  verified;
    Integer followersCount;
    Integer friendsCount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", verified=" + verified +
                ", followersCount=" + followersCount +
                ", friendsCount=" + friendsCount;
    }
}
