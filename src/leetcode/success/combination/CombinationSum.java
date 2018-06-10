package leetcode.success.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret=new ArrayList<List<Integer>>();
		int n=candidates.length;
		if(n<=0){
			return ret;
		}
		Stack<Integer> s=new Stack<>();
		dfs(ret,s,candidates,target,0);
		return ret;
	}

	private void dfs(List<List<Integer>> ret, Stack<Integer> s, int[] candidates, int target, int level){
		if(target==0){
			List<Integer> list=s.stream().collect(Collectors.toList());
			ret.add(list);
			return;
		}
		if(target<0){
			return;
		}
		for(int i=level;i<candidates.length;i++){
			target-=candidates[i];
			s.push(candidates[i]);
			dfs(ret,s, candidates, target,i);
			s.pop();
			target+=candidates[i];
		}
	}
	
	public static void main(String[] args) {
		CombinationSum s=new CombinationSum();
		
		int[] candidates;
		int target;
		int[][] expect;
		int expectLen;
		List<List<Integer>> output;
		int outputSize;
		
		candidates=new int[]{2,3,6,7};
		target=7;
		expect=new int[][]{ {2,2,3},{7}};
		expectLen=expect.length;
		output=s.combinationSum(candidates, target);
		outputSize=output.size();
		assert(expectLen==outputSize):"1:wrong";
		for (int i = 0; i < expectLen; i++) {

			String s1 = IntStream.of(expect[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));

			String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
			assert (s1.equals(s2)) : "1:wrong";
		}

		System.out.println("Finish");

	}

}
