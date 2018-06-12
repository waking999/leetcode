package leetcode.success.array;

import org.junit.Test;

import java.util.Map;
import java.util.HashMap;

class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];

			if (sumMap.containsKey(num)) {
				int pos = sumMap.get(num);
				return new int[] { pos, i };
			} else {
				sumMap.put(target - num, i);
			}

		}
		return null;
	}

	@Test
	public void test1() {
		int[] nums = { -3, 4, 3, 90 };
		int target = 0;
		int[] expect = { 0, 2 };

		int[] result = new TwoSum().twoSum(nums, target);
		for (int i = 0; i < expect.length; i++) {
			assert (expect[i] == result[i]):"1:wrong";
		}
		System.out.println("Finish");
	}
}