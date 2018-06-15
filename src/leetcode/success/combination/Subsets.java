package leetcode.success.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return ret;
        }
        ret.add(new ArrayList<>());
        Stack<Integer> s = new Stack<>();
        combin(ret, s, nums, 0);

        return ret;
    }

    private void combin(List<List<Integer>> ret, Stack<Integer> s, int[] nums, int level) {
        if (level == nums.length) {
            return;
        }

        for (int i = level; i < nums.length; i++) {
            s.push(nums[i]);
            List<Integer> l = new ArrayList<>(s);
            ret.add(l);
            combin(ret, s, nums, i + 1);
            s.pop();
        }
    }


}
