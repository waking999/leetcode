package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

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
        verify(expect, output, 1);

        candies = new int[]{1, 1, 2, 3};
        expect = 2;
        output = s.distributeCandies(candies);
        verify(expect, output, 2);


    }
}
