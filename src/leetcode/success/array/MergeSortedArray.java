package leetcode.success.array;

import org.junit.Test;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		for (int k = n + m - 1; k >= 0; k--) {
			if (i >= 0 && j >= 0) {
				if (nums1[i] >= nums2[j]) {
					nums1[k] = nums1[i];
					i--;
				} else {
					nums1[k] = nums2[j];
					j--;
				}
			} else if (i >= 0) {
				nums1[k] = nums1[i];
				i--;
			} else if (j >= 0) {
				nums1[k] = nums2[j];
				j--;
			}
		}
	}

	@Test
	public void test1() {
		MergeSortedArray s = new MergeSortedArray();

		int[] nums1 = { 1, 3, 5, 7, 9, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1 };
		int[] nums2 = { 2, 4, 6, 8 };
		int[] expect = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 };
		s.merge(nums1, 6, nums2, 4);
		for (int i = 0; i < expect.length; i++) {
			assert (nums1[i] == expect[i]) : "1.wrong " + i;
		}

		nums1 = new int[] { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		nums2 = new int[] { 1 };
		expect = new int[] { 0, 1 };
		s.merge(nums1, 1, nums2, 1);
		for (int i = 0; i < expect.length; i++) {
			assert (nums1[i] == expect[i]) : "2.wrong";
		}

		nums1 = new int[] { 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		nums2 = new int[] { 1 };
		expect = new int[] { 1 };
		s.merge(nums1, 0, nums2, 1);
		for (int i = 0; i < expect.length; i++) {
			assert (nums1[i] == expect[i]) : "2.wrong";
		}

		System.out.println("Finsih");

	}

}
