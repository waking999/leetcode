package leetcode.success.combination;

import leetcode.success.comm.Util;
import org.junit.Test;

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

	@Test
	public void test1() {
		Subsets s = new Subsets();

		int[] nums;
		int[][] expect;

		List<List<Integer>> output;
		int seq=1;

		nums = new int[] { 1, 2, 3 };
		expect = new int[][]   {{}, {1}, {1, 2}, {1, 2, 3}, {1, 3}, {2}, {2, 3}, {3}}  ;

		output = s.subsets(nums);
		Util.verifyUnsort(expect, output, seq++);

	}

}
