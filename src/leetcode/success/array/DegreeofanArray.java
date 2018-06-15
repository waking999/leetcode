package leetcode.success.array;


import java.util.Arrays;

public class DegreeofanArray {

    public int findShortestSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen == 0) {
            return 0;
        }
        if (numsLen == 1) {
            return 1;
        }
        int initMax = 49999 + 1;

        int[] start = new int[initMax];
        int[] end = new int[initMax];
        Arrays.fill(start, Integer.MIN_VALUE);
        Arrays.fill(end, Integer.MAX_VALUE);

        boolean[] exist = new boolean[initMax];
        Arrays.fill(exist, false);
        int[] degrees = new int[initMax];
        int maxDegree = 0;

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < numsLen; i++) {
            int num = nums[i];
            if (num > maxNum) {
                maxNum = num;
            }
            if (!exist[num]) {
                start[num] = i;
                exist[num] = true;
            } else {
                end[num] = i;
            }
            degrees[num]++;
            if (degrees[num] > maxDegree) {
                maxDegree = degrees[num];
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i <= maxNum; i++) {

            if (exist[i] && end[i] != Integer.MAX_VALUE && degrees[i] == maxDegree) {
                int numDis = end[i] - start[i] + 1;
                if (numDis < minDis) {
                    minDis = numDis;
                }
            }
        }

        if (minDis == Integer.MAX_VALUE) {
            return 1;
        }

        return minDis;


    }


}
