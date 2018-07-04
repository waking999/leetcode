package leetcode.success.array;

import common.Util;
import leetcode.success.array.FriendsOfAppropriateAges;
import org.junit.jupiter.api.Test;

public class FriendsOfAppropriateAgesTest {
    @Test
    public void test1() {
        FriendsOfAppropriateAges s = new FriendsOfAppropriateAges();

        int[] ages;
        int expect;
        int output;
        int seq = 1;

//        ages = new int[]{16, 16};
//        expect = 2;
//        output = s.numFriendRequests(ages);
//        Util.verify(expect, output, seq++);
//
//        ages = new int[]{16, 17, 18};
//        expect = 2;
//        output = s.numFriendRequests(ages);
//        Util.verify(expect, output, seq++);
//
//        ages = new int[]{20, 30, 100, 110, 120};
//        expect = 3;
//        output = s.numFriendRequests(ages);
//        Util.verify(expect, output, seq++);
//
//
//        ages = new int[]{16, 16, 16, 16, 17, 17};
//        expect = 22;
//        output = s.numFriendRequests(ages);
//        Util.verify(expect, output, seq++);

        ages = new int[]{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
        expect = 29;
        output = s.numFriendRequests(ages);
        Util.verify(expect, output, seq++);


    }


}
