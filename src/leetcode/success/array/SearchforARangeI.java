package leetcode.success.array;


public class SearchforARangeI {
    int left;
    int right;

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }

        int numsLen = nums.length;


        int start = 0;
        int end = numsLen - 1;

        left = -1;
        right = -1;

        search(nums, start, end, target, 0);

        return new int[]{left, right};
    }

    private void search(int[] nums, int start, int end, int target, int mode) {
        if (end < start) {
            return;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < target) {
            start = mid + 1;
        } else if (nums[mid] > target) {
            end = mid - 1;
        } else {

            if (mode == 0) {
                left = mid;
                right = mid;
                search(nums, start, mid - 1, target, -1);
                search(nums, mid + 1, end, target, 1);
            }
            if (mode == -1) {
                left = mid;
                search(nums, start, mid - 1, target, -1);
            }
            if (mode == 1) {
                right = mid;
                search(nums, mid + 1, end, target, 1);
            }

            return;
        }
        search(nums, start, end, target, mode);
    }


}
