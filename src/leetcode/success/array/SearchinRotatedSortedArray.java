package leetcode.success.array;

import leetcode.success.comm.Util;

public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(nums==null) {
			return -1;
		}
		int numsLen=nums.length;
		if(numsLen==0) {
			return -1;
		}
		if(numsLen==1) {
			if(target==nums[0]) {
				return 0;
			}else {
				return -1;
			}
		}
		
		int pos=search(nums,0,nums.length-1,target);
		return pos;
	}

	private int search(int[] nums, int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) / 2;
		 
			if (nums[mid] == target) {
				return mid;
			}
			 
			
			
			if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start]) 
                   end = mid - 1;
                else
                   start = mid + 1;
           } else if (nums[mid] <= nums[end]){
               if (target > nums[mid] && target <= nums[end])
                   start = mid + 1;
                else
                   end = mid - 1;
           }
 
		}
		
		if(start==end) {
			if(target==nums[start]) {
				return start;
			}else {
				return -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();

		int[] nums;
		int target;
		int expect;
		int output;
		int seq = 0;

		nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		target = 5;
		expect = 1;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
		nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		target = 1;
		expect = 5;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
		nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		target = 15;
		expect = -1;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);

		
		nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		target = -1;
		expect = -1;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
		
		nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		target = 3;
		expect = -1;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
		nums = new int[] { 1 };
		target = 1;
		expect = 0;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
		
		nums = new int[] { 1,3 };
		target = 3;
		expect = 1;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
		
//		nums = new int[] { 3,1,1,1 ,1};
//		target = 3;
//		expect = true;
//		output = s.search(nums, target);
//		Util.verify(expect, output, ++seq);
//		
//		nums = new int[] { 1,1};
//		target = 2;
//		expect = false;
//		output = s.search(nums, target);
//		Util.verify(expect, output, ++seq);
		
		nums = new int[] { 5,1,3};
		target = 3;
		expect = 2;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
		
//		nums = new int[] { 1,3,1,1,1};
//		target = 3;
//		expect = true;
//		output = s.search(nums, target);
//		Util.verify(expect, output, ++seq);
		
		nums = new int[] { 3,5,1};
		target = 3;
		expect = 0;
		output = s.search(nums, target);
		Util.verify(expect, output, ++seq);
		
//		nums = new int[] { 1,1,3,1};
//		target = 3;
//		expect = true;
//		output = s.search(nums, target);
//		Util.verify(expect, output, ++seq);
	}

}
