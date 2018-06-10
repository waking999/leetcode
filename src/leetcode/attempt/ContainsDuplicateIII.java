package leetcode.attempt;

import java.util.TreeSet;

import leetcode.success.comm.Util;

public class ContainsDuplicateIII {
	/**
	 * Given an array of integers, find out whether there are two distinct indices i
	 * and j in the array such that the absolute difference between nums[i] and
	 * nums[j] is at most t and the absolute difference between i and j is at most
	 * k.
	 * 
	 * @param nums
	 * @param k |i-j|<=k
	 * @param t |nums[i]-nums[j]|<=t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		 if (nums == null || nums.length <= 1 || k <= 0 || t < 0) {
	            return false;
	        }
	         
	        TreeSet<Integer> treeSet = new TreeSet<>();
	         
	        for (int i = 0; i < nums.length; i++) {
	            Integer floor = treeSet.floor(nums[i] + t);
	            Integer ceil = treeSet.ceiling(nums[i] - t);
	             
	            if ((floor != null && floor >= nums[i]) 
	                || (ceil != null && ceil <= nums[i])) {
	                return true;
	            }
	             
	            treeSet.add(nums[i]);
	             
	            if (i >= k) {
	                treeSet.remove(nums[i - k]);
	            }
	        }
	         
	        return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateIII s = new ContainsDuplicateIII();

		int[] nums;
		int k;
		int t;
		boolean expect;
		boolean output;

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		k = 5;
		t = 3;
		expect = true;
		output = s.containsNearbyAlmostDuplicate(nums, k, t);
		Util.verify(expect, output, 1);

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		k = 3;
		t = 1;
		expect = false;
		output = s.containsNearbyAlmostDuplicate(nums, k, t);
		Util.verify(expect, output, 2);

	}
}
