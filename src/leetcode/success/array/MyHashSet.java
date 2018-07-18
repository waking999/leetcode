package leetcode.success.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-hashset/description/
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 * <p>
 * Example:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
public class MyHashSet {

    private final static int IMPOSSIBLE_VALUE = -1;
    private static final float expandRate = 0.9F;
    private static final int initialSize = 1000;
    int[] keySet;
    int count;


    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        keySet = new int[initialSize];
        Arrays.fill(keySet, IMPOSSIBLE_VALUE);
        count = 0;
    }

    private void expand() {
        int size = keySet.length;
        if (count >= size * expandRate) {

            int[] newKeySet = new int[size + initialSize];
            Arrays.fill(newKeySet, IMPOSSIBLE_VALUE);
            System.arraycopy(keySet, 0, newKeySet, 0, count);
            keySet = newKeySet;
        }
    }

    public void add(int key) {
        int pos = findKeyPos(key);
        if (pos == IMPOSSIBLE_VALUE) {
            expand();
            keySet[count++] = key;
        }

    }

    private int findKeyPos(int key) {
        for (int i = 0; i < count; i++) {
            if (keySet[i] == key) {
                return i;
            }
        }
        return IMPOSSIBLE_VALUE;
    }

    public void remove(int key) {
        int pos = findKeyPos(key);
        if (pos != IMPOSSIBLE_VALUE) {
            moveToLeft(pos);
            count--;
        }
    }

    private void moveToLeft(int from) {
        for (int i = from; i <= count - 1; i++) {
            keySet[i] = keySet[i + 1];
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return findKeyPos(key) != IMPOSSIBLE_VALUE;
    }
}
