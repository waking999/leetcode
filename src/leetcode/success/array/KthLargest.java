package leetcode.success.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class KthLargest {

    private final static int IMPOSSIBLE_VALUE = -1;
    private static final float expandRate = 0.8F;
    private static final int initialSize = 12000;
    int[] nums;
    int count;

    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;

        this.nums = new int[initialSize];
        Arrays.fill(this.nums, IMPOSSIBLE_VALUE);
        Arrays.sort(nums);
        if(nums!=null) {
            count = nums.length;
            System.arraycopy(nums, 0, this.nums, 0, count);
        }else{
            count=0;
        }
    }

    public int add(int val) {
        int pos=findFirstLargerNumPos(val);
        moveToRight(pos);
        nums[pos]=val;
        count++;
        return nums[count-k];
    }

    private int findFirstLargerNumPos(int val){
         return binarySearch(val,0,count-1);
    }

    private int binarySearch(int val,int l, int r){
        if(l>r){
            return l;
        }
        int m=l+(r-l)/2;
        if(nums[m]>val){
            return binarySearch(val,l,m-1);
        }else{
            return binarySearch(val,m+1,r);
        }
    }


    private void moveToRight(int from){
        expand();
        for(int i=count;i>=from;i--){
            nums[i+1]=nums[i];
        }
    }

    private void expand(){
        int size=nums.length;
        if(count>=size*expandRate){
            int[] newNums=new int[size+initialSize];
            Arrays.fill(newNums,IMPOSSIBLE_VALUE);
            System.arraycopy(nums, 0, newNums, 0, count);
            nums=newNums;
        }
    }
}
