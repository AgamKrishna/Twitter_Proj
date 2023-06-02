package com.twitter.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterController {
	
	Twitter twitter;
	
	@GetMapping("/searchUsers")
    public QueryResult searchUsers(@RequestParam String search) throws TwitterException {
        Query query = new Query(search);
        QueryResult result = twitter.search(query);
        return result;
    }

    @GetMapping("/getUserTweets")
    public List<Status> getUserTweets(@RequestParam String screenName) throws TwitterException {
        return twitter.getUserTimeline(screenName);
    }

}
