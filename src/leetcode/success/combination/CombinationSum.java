package leetcode.success.combination;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret= new ArrayList<>();
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
			List<Integer> list= new ArrayList<>(s);
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

	@Test
	public void test1() {
		CombinationSum s=new CombinationSum();
		
		int[] candidates;
		int target;
		int[][] expect;

		List<List<Integer>> output;
		int seq=1;
		
		candidates=new int[]{2,3,6,7};
		target=7;
		expect=new int[][]{ {2,2,3},{7}};

		output=s.combinationSum(candidates, target);
		Util.verifyUnsort(expect, output, seq++);

	}

}
