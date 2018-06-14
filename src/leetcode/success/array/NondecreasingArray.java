package leetcode.success.array;


public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums == null) {
            return true;
        }
        int numsLen = nums.length;
        if (numsLen <= 1) {
            return true;
        }

        int count = 0;
        for (int i = 1; i < numsLen; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (count >= 2) {
                    return false;
                }
            }
            if (i != 1 && i != numsLen - 1) {
                if (nums[i - 2] > nums[i] && nums[i - 1] > nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }


}
