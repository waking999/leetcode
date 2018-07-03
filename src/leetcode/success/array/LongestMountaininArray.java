package leetcode.success.array;

/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 * <p>
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 * <p>
 * Given an array A of integers, return the length of the longest mountain.
 * <p>
 * Return 0 if there is no mountain.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 * <p>
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * Follow up:
 * <p>
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 */
public class LongestMountaininArray {
    public int longestMountain(int[] A) {
        if (A == null) {
            return 0;
        }
        int aLen = A.length;
        if (aLen <= 2) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int dis = 0;

        int i = 0;
        boolean up = false;
        boolean down = false;

        while (i < aLen - 1) {
            while (i < aLen - 1 && A[i + 1] <= A[i]) {
                i++;
            }
            start = i;

            //climb up
            while (i < aLen - 1 && A[i] < A[i + 1]) {
                i++;
                up = true;
            }

            //climb down
            while (i < aLen - 1 && A[i] > A[i + 1]) {
                i++;
                down = true;
            }
            end = i;

            if (up && down) {
                dis = Math.max(dis, end - start + 1);
            }
            start = end;
            up = false;
            down = false;
        }

        if (up && down) {
            dis = Math.max(dis, end - start + 1);
        }

        return dis;
    }
}
