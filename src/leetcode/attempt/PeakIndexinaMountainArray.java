package leetcode.attempt;

/**
 * Let's call an digits A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an digits that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Example 1:
 *
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 *
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        if(A==null){
            return -1;
        }
        int aLen=A.length;
        if(aLen==0){
            return -1;
        }
        if(aLen==1){
            return 0;
        }

        int start=0;
        int end=aLen-1;
        while(start<end){
            while(start<end&&A[start]<=A[end]){
                start++;
            }
            while(start<end&&A[start]>=A[end]){
                end--;
            }
        }



        return end;
    }
}
