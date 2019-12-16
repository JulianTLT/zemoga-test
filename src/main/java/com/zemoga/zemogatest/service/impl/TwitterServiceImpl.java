package com.zemoga.zemogatest.service.impl;

import com.zemoga.zemogatest.service.TwitterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterServiceImpl implements TwitterService {
    private Twitter twitter;
    private final static Integer MAX_TWEETS = 5;

    private static final Logger LOGGER = LogManager.getLogger(TwitterServiceImpl.class);

    public TwitterServiceImpl(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    public List<String> getTopFiveTweets(String screenName) {
        List<String> result = null;
        LOGGER.info("Trying to retrive top [{}] tweets from user [{}]", MAX_TWEETS, screenName);
        try {
            result = twitter.getUserTimeline(screenName)
                    .stream()
                    .map(Status::getText)
                    .limit(MAX_TWEETS).collect(Collectors.toList());
        } catch (TwitterException e) {
            e.printStackTrace();
            LOGGER.error("There was an error retrieving tweets from user [{}]", screenName, e);
        }

        LOGGER.info("Returning [{}]", result);
        return result;
    }
}
