package leetcode.success.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs0 {
    private Map<Integer, Integer> map;

    public ClimbingStairs0() {
        map = new HashMap<>();
    }

    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            map.put(0, 0);
            return 0;
        }
        if (n == 1) {
            map.put(1, 1);
            return 1;
        }
        if (n == 2) {
            map.put(2, 2);
            return 2;
        }
        int r = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, r);
        return r;
    }


}
