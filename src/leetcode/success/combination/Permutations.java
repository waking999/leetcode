package leetcode.success.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        if (n <= 0) {
            return ret;
        }
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        dfs(ret, s, visited, nums, n, 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, Stack<Integer> s, boolean[] visited, int[] nums, int n, int level) {
        if (level == n) {
            List<Integer> l = new ArrayList<>(s);
            ret.add(l);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                s.push(nums[i]);
                dfs(ret, s, visited, nums, n, level + 1);
                s.pop();
                visited[i] = false;
            }
        }
    }


}
