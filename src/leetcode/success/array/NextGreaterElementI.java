package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int[] ret=new int[nums1.length];
		for(int i=0;i<nums1.length;i++) {
			int pos=locate(nums2,nums1[i]);
			int[] subNums2=Arrays.copyOfRange(nums2, pos+1, nums2.length);
			ret[i]=nextGreater(subNums2,nums1[i]);
		}
		return ret;
	}
	
	private int locate(int[] nums2,int val) {
		for(int i=0;i<nums2.length;i++) {
			if(val==nums2[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private int nextGreater(int[] subNums2,int val) {
		for(int i=0;i<subNums2.length;i++) {
			if(subNums2[i]>val) {
				return subNums2[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		NextGreaterElementI s = new NextGreaterElementI();

		int[] nums1;
		int[] nums2;
		int[] expect;
		int[] output;

		nums1 = new int[] { 4, 1, 2 };
		nums2 = new int[] { 1, 3, 4, 2 };
		expect = new int[] { -1, 3, -1 };
		output = s.nextGreaterElement(nums1, nums2);
		Util.verifySort(expect, output, 1);

		nums1 = new int[] { 2, 4 };
		nums2 = new int[] { 1, 2, 3, 4 };
		expect = new int[] { 3, -1 };
		output = s.nextGreaterElement(nums1, nums2);
		Util.verifySort(expect, output, 2);
	}

}
