package leetcode.success.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = candidates.length;
        if (n <= 0) {
            return ret;
        }
        Stack<Integer> s = new Stack<>();
        dfs(ret, s, candidates, target, 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, Stack<Integer> s, int[] candidates, int target, int level) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(s);
            ret.add(list);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            target -= candidates[i];
            s.push(candidates[i]);
            dfs(ret, s, candidates, target, i);
            s.pop();
            target += candidates[i];
        }
    }


}
