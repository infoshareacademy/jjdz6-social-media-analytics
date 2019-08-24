package pl.com.socialmediaanalytics.twitter.presentation;

import java.time.LocalDate;
import java.util.List;

public class OriginalStatusDTO {

    private LocalDate createdAt;
    private String userName;
    private String screenName;
    private String usersProfileImageURL;
    private String text;
    private Integer favouriteCount;
    private Integer retweetCount;
    private List<MediaEntityDTO> mediaURLList;
    private List<String> hashtagList;
    private List<String> urlList;

    public OriginalStatusDTO() {
    }

    public OriginalStatusDTO(LocalDate createdAt, String userName, String screenName, String usersProfileImageURL,
                             String text, Integer favouriteCount, Integer retweetCount, List<MediaEntityDTO> mediaURLList, List<String> hashtagList, List<String> urlList) {
        this.createdAt = createdAt;
        this.userName = userName;
        this.screenName = screenName;
        this.usersProfileImageURL = usersProfileImageURL;
        this.text = text;
        this.favouriteCount = favouriteCount;
        this.retweetCount = retweetCount;
        this.mediaURLList = mediaURLList;
        this.hashtagList = hashtagList;
        this.urlList = urlList;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getUsersProfileImageURL() {
        return usersProfileImageURL;
    }

    public String getText() {
        return text;
    }

    public Integer getFavouriteCount() {
        return favouriteCount;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public List<MediaEntityDTO> getMediaURLList() {
        return mediaURLList;
    }

    public List<String> getHashtagList() {
        return hashtagList;
    }
}
