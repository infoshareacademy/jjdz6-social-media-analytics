package pl.com.socialmediaanalytics.twitter.service;

import pl.com.socialmediaanalytics.twitter.configurator.TwitterInstance;
import pl.com.socialmediaanalytics.twitter.dto.UserDTO;
import twitter4j.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class SearchUserService {

    @Inject
    TwitterInstance twitterInstance;

    public List<UserDTO> userDTOList(String user) {
        List<UserDTO> statusList = new ArrayList<>();
        try {
            Twitter twitter = twitterInstance.getTwitterInstance();
            if (user != null && !user.equals("")) {
                ResponseList<User> users = twitter.searchUsers(user, 1);
                for (User u : users) {
                    statusList.add(new UserDTO(u.getName(), getText(u.getStatus()), u.getFollowersCount()));

                }
            }
        } catch (TwitterException t) {
            t.printStackTrace();

        }
        return statusList;
    }

    private String getText(Status status) {
        return Optional
                .ofNullable(status)
                .map(Status::getText)
                .orElse("");
    }
}
