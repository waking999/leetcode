package leetcode.pending.dp;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * Note:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        if(A==null||B==null){
            return 0;
        }
        int aLen=A.length;
        int bLen=B.length;
        if(aLen==0||bLen==0){
            return 0;
        }

        int maxLen=0;
        for(int i=0;i<aLen-maxLen;i++){
            int a=A[i];
            int from=0;
            int pos=find(B,a,from);
            while(pos!=-1){
                int step=1;
                while(((i+step)<aLen)&&(pos+step<bLen)&&(A[i+step]==B[pos+step])){
                    step++;
                }
                maxLen=Math.max(maxLen,step);
                pos=find(B,a,pos+1);
            }

        }


        return maxLen;
    }

    private int find(int[] array,int target, int from){
        int arrayLen=array.length;
        for(int i=from;i<arrayLen;i++){
            if(target==array[i]){
                return i;
            }
        }
        return -1;
    }
}
