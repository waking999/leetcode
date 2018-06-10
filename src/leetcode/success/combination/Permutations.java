package leetcode.success.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
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
			List<Integer> l = s.stream().collect(Collectors.toList());
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

	public static void main(String[] args) {
		Permutations s = new Permutations();

		int[] nums;
		int[][] expect;
		int expectLen;
		List<List<Integer>> output;
		int outputSize;

		nums = new int[] { 1, 2, 3 };
		expect = new int[][] { { 1, 2, 3 }, { 1, 3, 2 }, { 2, 1, 3 }, { 2, 3, 1 }, { 3, 1, 2 }, { 3, 2, 1 } };
		expectLen = expect.length;
		output = s.permute(nums);
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
