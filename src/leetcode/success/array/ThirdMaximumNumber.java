package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		int numsLen = nums.length;

		if (numsLen == 1) {
			return nums[0];
		}
		if (numsLen == 2) {
			return Math.max(nums[0], nums[1]);
		}

		long first = Long.MIN_VALUE;
		long sec = Long.MIN_VALUE;
		long third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = sec;
                sec = first;
                first = num;
            } else if (num > sec && num < first) {
                third = sec;
                sec = num;
            } else if (num > third && num < sec) {
                third = num;
            }
        }
		if(third==Long.MIN_VALUE||third==sec){
			return (int)first;
		}else{
			return (int)third;
		}

	}

    @Test
    public void test1() {
		ThirdMaximumNumber s = new ThirdMaximumNumber();

		int[] nums;
		int expect;
		int output;

		nums = new int[] { 3, 2, 1 };
		expect = 1;
		output = s.thirdMax(nums);
		Util.verify(expect, output, 1);

		nums = new int[] { 1, 2 };
		expect = 2;
		output = s.thirdMax(nums);
		Util.verify(expect, output, 2);

		nums = new int[] { 2, 2, 3, 1 };
		expect = 1;
		output = s.thirdMax(nums);
		Util.verify(expect, output, 3);

		System.out.println("Finish");

	}

}
