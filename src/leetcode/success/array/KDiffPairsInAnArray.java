package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import leetcode.success.comm.Util;
import org.junit.Test;

public class KDiffPairsInAnArray {
	public int findPairs(int[] nums, int k) {
		if (nums == null) {
			return 0;
		}
		int numsLen = nums.length;
		if (numsLen == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		Set<Integer> keySet = map.keySet();
		int answer = 0;
		for (Integer i : keySet) {
			if(k == 0 && map.get(i) > 1) {
				answer++;
			}
			if(k > 0 && map.containsKey(i + k)) {
				answer++;
			}
		}

		return answer;
	}

    @Test
    public void test1() {
		KDiffPairsInAnArray s = new KDiffPairsInAnArray();

		int[] nums;
		int k;
		int expect;
		int output;

		nums = new int[] { 3, 1, 4, 1, 5 };
		k = 2;
		expect = 2;
		output = s.findPairs(nums, k);
		Util.verifyUnsort(expect, output, 1);

		nums = new int[] { 1, 2, 3, 4, 5 };
		k = 1;
		expect = 4;
		output = s.findPairs(nums, k);
		Util.verifyUnsort(expect, output, 2);

		nums = new int[] { 1, 3, 1, 5, 4 };
		k = 0;
		expect = 1;
		output = s.findPairs(nums, k);
		Util.verifyUnsort(expect, output, 3);

		System.out.println("Finish");

	}

}
