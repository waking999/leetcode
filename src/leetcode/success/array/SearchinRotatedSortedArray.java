package leetcode.success.array;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int numsLen = nums.length;
        if (numsLen == 0) {
            return -1;
        }
        if (numsLen == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }


            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }

        if (start == end) {
            if (target == nums[start]) {
                return start;
            } else {
                return -1;
            }
        }
        return -1;
    }


}
