package leetcode.success.array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int low = 0;
        int high = n - 1;
        while (low < high - 1) {
            if (nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = (low + high) / 2;
            if (nums[mid] > nums[low]) {
                // must be in right half
                low = mid;
            } else if (nums[mid] < nums[low]) {
                // must be in left half
                high = mid;
            }
        }

        return Math.min(nums[low], nums[high]);
    }


}
