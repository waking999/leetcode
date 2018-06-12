package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import leetcode.success.comm.Util;
import org.junit.Test;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		if(nums==null) {
			return 0;
		}
		int numsLen=nums.length;
		if(numsLen==0) {
			return 0;
		}
		Map<Integer,Integer> map=new HashMap<>();
		for(int num:nums) {
			if(map.containsKey(num)) {
				map.put(num,map.get(num)+1);
			}else {
				map.put(num, 1);
			}
		}
		
		Set<Integer> keySet=map.keySet();
		int max=0;
		for(int key:keySet) {
			if(map.containsKey(key+1)) {
				max=Math.max(max, map.get(key)+map.get(key+1));
			}
		}
		
		return max;
	}

    @Test
    public void test1() {
		LongestHarmoniousSubsequence s = new LongestHarmoniousSubsequence();

		int[] nums;
		int expect;
		int output;
		
		nums=new int[] {1,3,2,2,5,2,3,7};
		expect=5;
		output=s.findLHS(nums);
		Util.verifyUnsort(expect, output, 1);
	}

}
