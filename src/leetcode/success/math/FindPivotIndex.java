package leetcode.success.math;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int numsLen = nums.length;
        if (numsLen == 0) {
            return -1;
        }
        if (numsLen == 1) {
            return 0;
        }

        int[] sumNums = new int[numsLen + 2];
        sumNums[0] = 0;
        sumNums[1] = nums[0];
        sumNums[numsLen + 1] = 0;
        for (int i = 2; i < numsLen + 1; i++) {
            sumNums[i] = sumNums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < numsLen + 1; i++) {
            int left = sumNums[i - 1];
            int right = sumNums[numsLen] - sumNums[i];
            if (left == right) {
                return i - 1;
            }
        }

        return -1;
    }


}
