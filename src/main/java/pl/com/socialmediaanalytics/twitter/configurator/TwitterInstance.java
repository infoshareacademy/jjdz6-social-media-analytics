package pl.com.socialmediaanalytics.twitter.configurator;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import javax.enterprise.context.ApplicationScoped;

    @ApplicationScoped
    public class TwitterInstance {

        private Twitter twitter;

        public TwitterInstance() {
            TwitterFactory tf = new TwitterFactory();
            this.twitter =  tf.getInstance();
        }

        public Twitter getTwitterInstance() {
            return twitter;
        }
    }

