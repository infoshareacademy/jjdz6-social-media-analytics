package pl.com.socialmediaanalytics.twitter.service;

import twitter4j.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;


@RequestScoped
public class TwitterSearchService {

    @Inject
    TwitterInstanceService twitterInstanceService;

    public List<Status> searchTweets(String userQuery, String date, String lang, String type )
            throws TwitterException {

        Twitter twitter = twitterInstanceService.getTwitterInstance();
        Query query = new Query(userQuery);

        if(!type.equals("all")) {
            Query.ResultType resultType = Query.ResultType.valueOf(type);
            query.setResultType(resultType);
        }

        query.setUntil(date);
        query.lang(lang);
        QueryResult result;

        result = twitter.search(query);

        return result.getTweets();
    }

}
