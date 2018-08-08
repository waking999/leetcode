package leetcode.success.other;

import common.Util;
import org.junit.jupiter.api.Test;


import java.util.List;

public class TwitterTest {
    @Test
    public void test1() {
        String[] operations = new String[]{"Twitter", "postTweet", "getNewsFeed", "follow", "postTweet",
                "getNewsFeed", "unfollow", "getNewsFeed"};
        int[][] params = new int[][]{{}, {1, 5}, {1}, {1, 2}, {2, 6},
                {1}, {1, 2}, {1}};
        Integer[][] expects = new Integer[][]{null, null, {5}, null, null,
                {6, 5}, null, {5}};

        runTest(operations, params, expects);

    }
    @Test
    public void test2() {
        String[] operations = new String[]{"Twitter","postTweet","follow","getNewsFeed"};
        int[][] params = new int[][]{{}, {1, 5}, {1,1}, {1}};
        Integer[][] expects = new Integer[][]{null, null,null, {5}};

        runTest(operations, params, expects);
    }


    @Test
    public void test3() {
        String[] operations = new String[]{"Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"};
        int[][] params = new int[][]{{}, {1,5},{1,3},{1,101},{1,13},{1,10},{1,2},{1,94},{1,505},{1,333},{1,22},{1,11},{1}};
        Integer[][] expects = new Integer[][]{null,null,null,null,null,null,null,null,null,null,null,null,{11,22,333,505,94,2,10,13,101,3}};

        runTest(operations, params, expects);
    }


    private void runTest(String[] operations, int[][] params, Integer[][] expects) {
        Twitter t = null;
        int seq = 1;

        int len = operations.length;
        for (int i = 0; i < len; i++) {
            String op = operations[i];
            int[] param = params[i];
            if ("Twitter".equals(op)) {
                t = new Twitter();
            } else if ("postTweet".equals(op)) {
                assert t != null;
                t.postTweet(param[0], param[1]);
            } else if ("getNewsFeed".equals(op)) {
                assert t != null;
                List<Integer> output = t.getNewsFeed(param[0]);
                Integer[] expect = expects[i];
                Util.verifyUnsort(expect, output, seq++);
            } else if ("follow".equals(op)) {
                assert t != null;
                t.follow(param[0], param[1]);
            } else if ("unfollow".equals(op)) {
                assert t != null;
                t.unfollow(param[0], param[1]);
            }
        }

    }
}
