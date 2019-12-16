package com.zemoga.zemogatest.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@PropertySource("classpath:application.properties")
public class TwitterConfig {
    @Value("${twitter.oauth.consumer.key}")
    String OAuthConsumerKey;
    @Value("${twitter.oauth.consumer.secret}")
    String OAuthConsumerSecret;
    @Value("${twitter.oauth.accesstoken}")
    String OAuthAccessToken;
    @Value("${twitter.oauth.accesstoken.secret}")
    String OAuthAccessTokenSecret;

    @Bean
    public twitter4j.conf.Configuration twitterConfiguration(){
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder
                .setDebugEnabled(true)
                .setOAuthConsumerKey(OAuthConsumerKey)
                .setOAuthConsumerSecret(OAuthConsumerSecret)
                .setOAuthAccessToken(OAuthAccessToken)
                .setOAuthAccessTokenSecret(OAuthAccessTokenSecret);
        return configurationBuilder.build();
    }

    @Bean
    public Twitter twitterInstance(twitter4j.conf.Configuration twitterConfiguration){
        return new TwitterFactory(twitterConfiguration).getInstance();
    }
}

