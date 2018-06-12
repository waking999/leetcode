package leetcode.success.other;

import java.util.*;

public class TwoSumIII {
    /**
     * 设计b并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
     * add -把这个数添加到内部的数据结构。
     * find -是否存在任意一对数字之和等于这个值
     */
    private List<Integer> nums;
    private int numsLen;
    private Set<Integer> set;

    TwoSumIII() {
        nums = new ArrayList<>();
        numsLen = 0;
        set = new HashSet<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        for (int i = 0; i < numsLen; i++) {
            int num = nums.get(i);
            int sum = number + num;
            set.add(sum);
        }


        nums.add(number);
        numsLen++;
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        if (numsLen < 2) {
            return false;
        }
        return set.contains(value);
    }




}
