package leetcode.success.array;

import java.util.Arrays;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        if (candies == null) {
            return 0;
        }
        int candiesLen = candies.length;
        if (candiesLen == 0) {
            return 0;
        }
        Arrays.sort(candies);
        int kind = 0;
        for (int i = 0; i < candiesLen; i++) {
            if (i == 0 || candies[i] != candies[i - 1]) {
                kind++;
            }
        }
        return Math.min(kind, candiesLen / 2);

    }


}
