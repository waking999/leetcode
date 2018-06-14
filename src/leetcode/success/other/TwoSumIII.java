package leetcode.success.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSumIII {
    /**
     * 设计b并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
     * add -把这个数添加到内部的数据结构。
     * find -是否存在任意一对数字之和等于这个值
     */
    private Map<Integer, Integer> map;

    TwoSumIII() {
        map = new HashMap<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        if (map.containsKey(number)) {
            int count = map.get(number);
            map.put(number, count + 1);
        } else {
            map.put(number, 1);
        }
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            int target = value - key;
            if (map.containsKey(target)) {
                if ((target != key && map.get(target) > 0) || (target == key && map.get(target) > 1)) {
                    return true;
                }
            }
        }
        return false;

    }


}
