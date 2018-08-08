package leetcode.success.other;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/description/
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, Set<Tweet>> tweets;
    class Tweet implements Comparable<Tweet>{
        int id;
        int seq;

        Tweet(int id){
            this.id=id;
            this.seq=tweetSeq;
            tweetSeq++;
        }

        @Override
        public int compareTo(Tweet b){
            return b.seq-this.seq;
        }
    }
    private int tweetSeq;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        tweetSeq=0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (tweets.containsKey(userId)) {
            Set<Tweet> s = tweets.get(userId);
            s.add(new Tweet(tweetId));
        } else {
            Set<Tweet> s = new HashSet<>();
            s.add(new Tweet(tweetId));
            tweets.put(userId, s);
        }
    }

    private void putSet(int key, int eleId, Map<Integer, Set<Integer>> map) {
        if (map.containsKey(key)) {
            Set<Integer> s = map.get(key);
            s.add(eleId);
        } else {
            Set<Integer> s = new HashSet<>();
            s.add(eleId);
            map.put(key, s);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> rtnTweet = new ArrayList<>();
        int rtnTweetCount=0;
        Set<Tweet> usersTweets = tweets.get(userId);
        if (usersTweets != null) {
            rtnTweet.addAll(usersTweets);
            rtnTweetCount+=usersTweets.size();
        }

        Set<Integer> userFollows = follows.get(userId);
        if (userFollows != null) {
            for (int tmpUserId : userFollows) {
                Set<Tweet> tmpUsersTweets = tweets.get(tmpUserId);
                if (tmpUsersTweets != null) {
                    rtnTweet.addAll(tmpUsersTweets);
                    rtnTweetCount+=tmpUsersTweets.size();
                }
            }
        }
        Collections.sort(rtnTweet);
        List<Integer> rtn=new ArrayList<>();
        if(rtnTweetCount<=10) {
            for (Tweet t : rtnTweet) {
                rtn.add(t.id);
            }
        }else{
            for(int i=0;i<10;i++){
                Tweet t=rtnTweet.get(i);
                rtn.add(t.id);
            }
        }
        return rtn;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId){
            return;
        }
        putSet(followerId, followeeId, follows);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            Set<Integer> s = follows.get(followerId);
            s.remove(followeeId);
        }
    }
}
