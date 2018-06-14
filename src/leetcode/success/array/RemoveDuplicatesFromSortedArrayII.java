package leetcode.success.array;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}

		int num = 0;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[j]) {
				num++;
				if(num<2){					
					nums[++j]=nums[i];
				}
			} else {
				nums[++j] = nums[i];
				num = 0;
			}
		}

		return j + 1;
	}


}
