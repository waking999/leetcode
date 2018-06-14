package leetcode.pending;

import leetcode.success.comm.Util;
import org.junit.Test;

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

    @Test
    public void test1() {
        Combinations s = new Combinations();

        int n;
        int k;
        int[][] expect;

        List<List<Integer>> output;
        int seq = 1;

        n = 4;
        k = 2;
        expect = new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};

        output = s.combine(n, k);
        Util.verifyUnsort(expect, output, seq++);


    }

}
