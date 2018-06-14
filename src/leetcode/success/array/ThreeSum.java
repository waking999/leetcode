package leetcode.success.array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        int numsLen = nums.length;
        Arrays.sort(nums);

        int firstOPos = findPosFromLeftToRight(nums, numsLen, 0);
        int last0Pos = firstOPos;
        if (firstOPos != -1) {
            last0Pos = findPosFromRightToLeft(nums, numsLen - 1, firstOPos - 1, 0);
        }
        List<List<Integer>> rtn = new ArrayList<>();
        if (last0Pos - firstOPos >= 2) {
            // 3 0s
            List<Integer> lst = new ArrayList<>();
            lst.add(0);
            lst.add(0);
            lst.add(0);
            rtn.add(lst);
        }

        int firstPositive = last0Pos + 1;
        if (last0Pos == -1) {
            firstPositive = findFirstPositive(nums, numsLen);
        }
        if (firstPositive == -1 || firstPositive == numsLen) {
            return rtn;
        }

        int lastNeg = firstOPos - 1;
        if (firstOPos == -1) {
            lastNeg = findLastNeg(nums, numsLen - 1);
        }
        if (lastNeg == -1) {
            return rtn;
        }


        if (firstOPos != -1) {
            //1 0s
            for (int i = 0; i <= lastNeg; i++) {
                while (nums[i] == nums[i + 1]) {
                    i++;
                }

                int num = nums[i];
                int oppoPos = findPosFromRightToLeft(nums, numsLen - 1, Math.max(firstOPos, last0Pos), 0 - num);
                if (oppoPos != -1) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(num);
                    lst.add(0);
                    lst.add(0 - num);
                    rtn.add(lst);
                }
            }
        }


        Map<String, List<Integer>> map = new HashMap<>();
        //no 0s
        //neg 2, positive 1
        for (int i = firstPositive; i < numsLen; i++) {
            List<int[]> negPos = twoSum(nums, 0, lastNeg + 1, 0 - nums[i]);

            for (int[] negPo : negPos) {

                String key = Integer.toString(nums[negPo[0]]) + "," + Integer.toString(nums[negPo[1]]) + "," + Integer.toString(nums[i]);
                if (!map.containsKey(key)) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[negPo[0]]);
                    lst.add(nums[negPo[1]]);
                    lst.add(nums[i]);
                    map.put(key, lst);
                }


            }
        }

        //neg 1, positive 2
        for (int i = 0; i <= lastNeg; i++) {
            List<int[]> posPos = twoSum(nums, firstPositive, numsLen, 0 - nums[i]);

            for (int[] posPo : posPos) {
                String key = Integer.toString(nums[i]) + "," + Integer.toString(nums[posPo[0]]) + "," + Integer.toString(nums[posPo[1]]);
                if (!map.containsKey(key)) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[posPo[0]]);
                    lst.add(nums[posPo[1]]);
                    lst.add(nums[i]);
                    map.put(key, lst);
                }

            }
        }

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            rtn.add(map.get(key));
        }


        return rtn;
    }

    private List<int[]> twoSum(int[] array, int from, int to, int target) {
        List<int[]> rtn = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = from; i < to; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement)) {
                rtn.add(new int[]{map.get(complement), i});
            }
            map.put(array[i], i);
        }
        return rtn;
    }

    private int findFirstPositive(int[] array, int to) {
        for (int i = 0; i < to; i++) {
            if (array[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private int findLastNeg(int[] array, int from) {
        for (int i = from; i >= 0; i--) {
            if (array[i] < 0) {
                return i;
            }
        }
        return -1;
    }


    private int findPosFromLeftToRight(int[] array, int to, int val) {
        for (int i = 0; i < to; i++) {
            if (val == array[i]) {
                return i;
            }
        }
        return -1;
    }

    private int findPosFromRightToLeft(int[] array, int from, int to, int val) {
        for (int i = from; i > to; i--) {
            if (val == array[i]) {
                return i;
            }
        }
        return -1;
    }


}
