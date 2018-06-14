package leetcode.success.combination;

import leetcode.success.comm.Util;
import org.junit.Test;

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

	@Test
	public void test1() {
		Permutations s = new Permutations();

		int[] nums;
		int[][] expect;
		List<List<Integer>> output;
		int seq=1;

		nums = new int[] { 1, 2, 3 };
		expect = new int[][] { { 1, 2, 3 }, { 1, 3, 2 }, { 2, 1, 3 }, { 2, 3, 1 }, { 3, 1, 2 }, { 3, 2, 1 } };

		output = s.permute(nums);
		Util.verifyUnsort(expect, output, seq++);

	}

}
