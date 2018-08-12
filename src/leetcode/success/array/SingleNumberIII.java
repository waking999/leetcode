package leetcode.success.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number-iii/description/
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if(nums==null){
            return null;
        }
        int numsLen=nums.length;
        if(numsLen<=2){
            return nums;
        }
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        int setSize=set.size();
        int[] rtn=new int[setSize];
        int p=0;
        Iterator<Integer> it=set.iterator();
        while(it.hasNext()){
            rtn[p++]=it.next();
        }


        return rtn;
    }
}
