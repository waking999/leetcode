package leetcode.success.array;

public class RotateArray {


    public void rotate(int[] nums, int k) {
        int numsLen = nums.length;
        if (numsLen <= 1) {
            return;
        }
        if (k <= 0) {
            return;
        }
        k = k % numsLen;
        for (int i = 1; i <= k; i++) {
            int t = nums[numsLen - 1];

            System.arraycopy(nums, 0, nums, 1, numsLen - 2 + 1);
            nums[0] = t;
        }

    }


}
