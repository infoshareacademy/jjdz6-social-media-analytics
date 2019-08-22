package pl.com.socialmediaanalytics.twitter.service;

import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.dto.UserDTO;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class SearchUserService {

    @Inject
    TwitterInstance twitterInstance;

    public List<UserDTO> userDTOList(String user) {
        List<UserDTO>statusList = new ArrayList<>();
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            if (user!= null && !user.equals("")) {
                ResponseList<User> users = twitter.searchUsers(user, 1);
                for (User u : users) {
                    statusList.add(new UserDTO(u.getName(), u.getStatus().getText(), u.getMiniProfileImageURL(),u.getFollowersCount()));
                }
            }
        } catch (
                TwitterException t) {
            t.printStackTrace();
        }
        return statusList;
    }
}
