package leetcode.success.array;


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
        if (third == Long.MIN_VALUE || third == sec) {
            return (int) first;
        } else {
            return (int) third;
        }

    }


}
