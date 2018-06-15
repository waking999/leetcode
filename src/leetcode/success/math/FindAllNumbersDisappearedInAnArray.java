package leetcode.success.math;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
//	public List<Integer> findDisappearedNumbers(int[] nums) {
//		List<Integer> ret=new ArrayList<>();
//		if(nums==null){
//			return ret;
//		}
//		int numsLen=nums.length;
//		if(numsLen==0){
//			return ret;
//		}
//		int[] counts=new int[numsLen+1];
//		for(int i=0;i<numsLen;i++){
//			counts[nums[i]]++;
//		}
//		
//		for(int i=1;i<=numsLen;i++){
//			if(counts[i]==0){
//				ret.add(i);
//			}
//		}
//		
//		return ret;
//	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret=new ArrayList<>();
		if(nums==null){
			return ret;
		}
		int numsLen=nums.length;
		if(numsLen==0){
			return ret;
		}
		for (int i = 0; i < numsLen; ++i) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = (nums[idx] > 0) ? -nums[idx] : nums[idx];
        }
        for (int i = 0; i <numsLen; ++i) {
            if (nums[i] > 0) {
                ret.add(i+1);
            }
        }
        
		
		return ret;
	}
	

}
