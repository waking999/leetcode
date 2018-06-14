package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		if(nums==null) {
			return 0;
		}
        int count=0;
		int ret=0;
        for (int num : nums) {
            count = (num == 0) ? 0 : count + 1;
            ret = Math.max(ret, count);
        }
		
		return ret;
				
	}


}
