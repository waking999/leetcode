package leetcode.success.math;

import java.util.ArrayList;
import java.util.List;

import leetcode.success.comm.Util;

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
	
	public static void main(String[] args) {
		FindAllNumbersDisappearedInAnArray s = new FindAllNumbersDisappearedInAnArray();

		int[] nums;
		int[] expect;
		List<Integer> output;

		nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		expect = new int[] { 5, 6 };
		output = s.findDisappearedNumbers(nums);
		Util.verifySort(expect, output, 1);

		System.out.println("Finish");

	}
}
