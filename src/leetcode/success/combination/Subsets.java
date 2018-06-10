package leetcode.success.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		int n = nums.length;
		if (n == 0) {
			return ret;
		}
		ret.add(new ArrayList<Integer>());
		Stack<Integer> s = new Stack<Integer>();
		combin(ret, s, nums, 0);

		return ret;
	}

	private void combin(List<List<Integer>> ret, Stack<Integer> s, int[] nums, int level) {
		if (level == nums.length) {
			return;
		}

		for (int i = level; i < nums.length; i++) {
			s.push(nums[i]);
			List<Integer> l = s.stream().collect(Collectors.toList());
			ret.add(l);
			combin(ret, s, nums, i + 1);
			s.pop();
		}
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();

		int[] nums;
		int[][] expect;
		int expectLen;
		List<List<Integer>> output;
		int outputSize;

		nums = new int[] { 1, 2, 3 };
		expect = new int[][]   {{}, {1}, {1, 2}, {1, 2, 3}, {1, 3}, {2}, {2, 3}, {3}}  ;
		expectLen = expect.length;
		output = s.subsets(nums);
		outputSize = output.size();

		assert (expectLen == outputSize) : "1:wrong";
		for (int i = 0; i < expectLen; i++) {

			String s1 = IntStream.of(expect[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));

			String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
			assert (s1.equals(s2)) : "1:wrong";
		}

		System.out.println("Finish");

	}

}
