package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null) {
			return false;
		}
		int numsLen = nums.length;
		if (numsLen < 2) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numsLen; i++) {
			if (map.containsKey(nums[i])) {
				int pos = map.get(nums[i]);
				if (i - pos <= k) {
					return true;
				}
			}
			map.put(nums[i], i);

		}

		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII s = new ContainsDuplicateII();

		int[] nums;
		int k;
		boolean expect;
		boolean output;

		nums = new int[] { 1, 2, 3, 4, 1, 5 };
		k = 4;
		expect = true;
		output = s.containsNearbyDuplicate(nums, k);
		assert (expect == output) : "1:wrong";

		nums = new int[] { 1, 2, 3, 4, 1, 5 };
		k = 2;
		expect = false;
		output = s.containsNearbyDuplicate(nums, k);
		assert (expect == output) : "2:wrong";

		nums = new int[] { 1, 2, 3, 4, 6, 5 };
		k = 4;
		expect = false;
		output = s.containsNearbyDuplicate(nums, k);
		assert (expect == output) : "3:wrong";

		nums = new int[] { 1, 0, 1, 1 };
		k = 1;
		expect = true;
		output = s.containsNearbyDuplicate(nums, k);
		assert (expect == output) : "4:wrong";

		nums = new int[] { 1, 2, 1 };
		k = 1;
		expect = false;
		output = s.containsNearbyDuplicate(nums, k);
		assert (expect == output) : "5:wrong";

	}

}
