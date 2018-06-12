package leetcode.success.array;


import leetcode.success.comm.Util;
import org.junit.Test;

public class SearchforARangeI {
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

    int left;
    int right;

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

    @Test
    public void testsearchRange() {
        SearchforARangeI s = new SearchforARangeI();

        int[] nums;
        int target;
        int[] expect;
        int[] output;
        int seq = 0;


        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 8;
        expect = new int[]{3, 4};
        output = s.searchRange(nums, target);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;
        expect = new int[]{-1, -1};
        output = s.searchRange(nums, target);
        Util.verifyUnsort(expect, output, seq++);

    }

}
