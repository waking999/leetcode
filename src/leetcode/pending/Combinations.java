package leetcode.pending;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n <= 0) {
            return ret;
        }
        Stack<Integer> com = new Stack<>();
        combine(ret, com, n, k, 1);
        return ret;
    }

    private void combine(List<List<Integer>> ret, Stack<Integer> com, int n, int k, int level) {
        if (com.size() == k) {
            List<Integer> list = new ArrayList<>(com);

            ret.add(list);
            return;
        }

        if (com.size() > k) {
            return;
        }

        for (int i = level; i <= n; i++) {
            com.push(i);
            combine(ret, com, n, k, i + 1);
            com.pop();
        }

    }


}
