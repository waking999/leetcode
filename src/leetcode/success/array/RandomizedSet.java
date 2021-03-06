package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class RandomizedSet {
    private Random r;
    private final static int INIT_SET_SIZE = 10000;
    private int totalCount;
    private int[] vals;
    private Map<Integer, Integer> valIdxs;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        r = new Random();
        totalCount = 0;
        vals = new int[INIT_SET_SIZE];
        valIdxs = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valIdxs.containsKey(val)) {
            return false;
        } else {
            vals[totalCount] = val;
            valIdxs.put(val, totalCount);
            totalCount++;
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valIdxs.containsKey(val)) {
            return false;
        } else {
            int idx = valIdxs.get(val);
            valIdxs.remove(val, idx);
            totalCount--;
            int tmp = vals[totalCount];
            vals[totalCount] = val;
            vals[idx] = tmp;
            if (tmp != val) {
                valIdxs.put(tmp, idx);
            }
            return true;
        }
    }


    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int idx = r.nextInt(totalCount);
        return vals[idx];
    }
}
