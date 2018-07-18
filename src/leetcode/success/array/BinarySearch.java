package leetcode.success.array;

/**
 * https://leetcode.com/problems/binary-search/description/
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Note:
 *
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums==null){
            return -1;
        }

        int numsLen=nums.length;
        if(numsLen==0){
            return -1;
        }


        return binarySearch(nums,target,0,numsLen-1);
    }

    private int binarySearch(int[] nums,int target, int l, int r){
        if(l>r){
            return -1;
        }else if(l==r){
            if(nums[l]==target){
                return l;
            }else{
                return -1;
            }
        }else {
            int m=l+(r-l)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                return binarySearch(nums,target,l,m-1);
            }else {
                return binarySearch(nums,target,m+1,r);
            }
        }
    }
}
