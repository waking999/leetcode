package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;
import org.junit.Test;

public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
		if(nums==null) {
			return null;
		}
		int numsLen=nums.length;
		if(numsLen==0) {
			return null;
		}
		int[] nums1=Arrays.copyOf(nums, numsLen);
		Arrays.sort(nums1);
		String[] ret=new String[numsLen];
		for(int i=0;i<numsLen;i++) {
			int rank=numsLen-locate(nums1,nums[i]);
			
			if(rank==1) {
				ret[i]="Gold Medal";
			}else if(rank==2) {
				ret[i]="Silver Medal";
			}else if(rank==3) {
				ret[i]= "Bronze Medal";
			}else   {
				ret[i]=Integer.toString(rank);
			}
		}
		return ret;
	}
	
	private int locate(int[] array, int num) {
		int low=0;
		int high=array.length-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(array[mid]==num) {
				return mid;
			}else if(array[mid]<num) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return -1;
	}

    @Test
    public void test1() {
		RelativeRanks s = new RelativeRanks();

		int[] nums;
		String[] expect;
		String[] output;

		nums = new int[] { 5, 4, 3, 2, 1 };
		expect = new String[] { "Gold Medal", "Silver Medal", "Bronze Medal", "4", "5" };
		output = s.findRelativeRanks(nums);
		Util.verifyUnsort(expect, output, 1);
		
		
		nums = new int[] { 1, 4, 5, 3, 2 };
		expect = new String[] { "5", "Silver Medal", "Gold Medal", "Bronze Medal", "4" };
		output = s.findRelativeRanks(nums);
		Util.verifyUnsort(expect, output, 1);

	}

}
