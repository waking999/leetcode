package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

public class PredicttheWinner {
	
 
	public boolean PredictTheWinner(int[] nums) {
		int numsLen=nums.length;
		int score=0;
		
	    return false;
		
	}
	
	private boolean dfs(int[] nums,int start, int end,int player) {
		 return false;
	}


	@Test
	public void test1() {
		PredicttheWinner s=new PredicttheWinner();
		
		int[] nums;
		boolean expect;
		boolean output;
		
		nums=new int[] {1, 5, 2};
		expect=false;
		output=s.PredictTheWinner(nums);
		Util.verify(expect, output, 1);
		
		
		nums=new int[] {1, 5, 233, 7};
		expect=true;
		output=s.PredictTheWinner(nums);
		Util.verify(expect, output, 2);
		
		
		 
	}

}
