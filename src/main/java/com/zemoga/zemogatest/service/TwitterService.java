package com.zemoga.zemogatest.service;

import java.util.List;

public interface TwitterService {
    List<String> getTopFiveTweets(String screenName);
}
