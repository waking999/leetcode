package leetcode.success.array;

import common.Util;
import org.junit.Test;

public class DistributeCandiesTest {
    @Test
    public void test1() {
        DistributeCandies s = new DistributeCandies();

        int[] candies;
        int expect;
        int output;

        candies = new int[]{1, 1, 2, 2, 3, 3};
        expect = 3;
        output = s.distributeCandies(candies);
        Util.verify(expect, output, 1);

        candies = new int[]{1, 1, 2, 3};
        expect = 2;
        output = s.distributeCandies(candies);
        Util.verify(expect, output, 2);


    }
}
