package leetcode.success.array;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int numsLen=nums.length;
		if(numsLen==0){
			return 0;
		}
		
		int j=0;
		for(int i=1;i<numsLen;i++){
			if(nums[j]!=nums[i]){
				j++;
				nums[j]=nums[i];
			}
		}
		return j+1;
	}



}
