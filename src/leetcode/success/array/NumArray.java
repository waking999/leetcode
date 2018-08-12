package leetcode.success.array;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * Example:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * <p>
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class NumArray {
    private int[] nums;
    private int numsLen;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.numsLen=nums.length;
    }

    public void update(int i, int val) {
        if(i<numsLen){
            this.nums[i]=val;
        }
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=nums[k];
        }
        return sum;
    }
}
