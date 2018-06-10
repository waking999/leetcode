package history.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import history.common.ISolution;

public class IntersectionOfTwoArraysII implements ISolution<Return, Input> {
	public int[] intersect(int[] nums1, int[] nums2) {

		int nums1Len = nums1.length;
		int nums2Len = nums2.length;

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> numList = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		for (; i < nums1Len && j < nums2Len;) {
			if (nums1[i] < nums2[j]) {
				i++;

			} else if (nums2[j] < nums1[i]) {
				j++;
			} else {
				numList.add(nums1[i]);
				i++;
				j++;
			}
		}

		int numListSize = numList.size();
		int[] nums = new int[numListSize];

		for (int k = 0; k < numListSize; k++) {
			nums[k] = numList.get(k).intValue();
		}

		return nums;
	}

	@Override
	public Return solution(Input i) {
		int[] nums1 = i.getNums1();
		int[] nums2 = i.getNums2();

		int[] nums = intersect(nums1, nums2);
		Return r = new Return(nums);
		return r;
	}

	@Test
	public void test1() {
		ISolution<Return, Input> s = new IntersectionOfTwoArraysII();
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		Input i = new Input(nums1, nums2);
		int[] nums = { 2, 2 };
		Return e = new Return(nums);
		s.test(i, e);
	}

	@Test
	public void test2() {
		ISolution<Return, Input> s = new IntersectionOfTwoArraysII();
		int[] nums1 = { 1, 2, 2, 3, 1, 3 };
		int[] nums2 = { 2, 3, 2 };
		Input i = new Input(nums1, nums2);
		int[] nums = { 2, 2, 3 };
		Return e = new Return(nums);
		s.test(i, e);
	}
}
