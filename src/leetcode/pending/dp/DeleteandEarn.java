package leetcode.pending.dp;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * https://leetcode.com/problems/delete-and-earn/description/
 * <p>
 * Given an array nums of integers, you can perform operations on the array.
 * <p>
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * <p>
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * <p>
 * Example 1:
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation:
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 * Example 2:
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 * Explanation:
 * Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 * Note:
 * <p>
 * The length of nums is at most 20000.
 * Each element nums[i] is an integer in the range [1, 10000].
 */
public class DeleteandEarn {


//    class NumWrap implements Comparable<NumWrap>{
//        int number;
//        int sum;
//
//        NumWrap(int number, int sum){
//            this.number=number;
//            this.sum=sum;
//        }
//
//        @Override
//        public int compareTo(NumWrap b){
//            return b.sum-this.sum;
//        }
//    }

    private void mergeSort(int[] numIdx,int[] numSum,int l,int r){
        if(l<r){
            int m=l+(r-l)/2;

            mergeSort(numIdx,numSum,l,m);
            mergeSort(numIdx,numSum,m+1,r);
            merge(numIdx,numSum,l,m,r);
        }
    }

    private void merge(int[] numIdx,int[] numSum,int l,int m, int r){

        int[] numIdxL=new int[m-l+1];
        int[] numIdxR=new int[r-m];

        int[] numSumL=new int[m-l+1];
        int[] numSumR=new int[r-m];

        for(int i=0;i<m-l+1;i++){
            numIdxL[i]=numIdx[l+i];
            numSumL[i]=numSum[l+i];
        }
        for(int i=0;i<r-m;i++){
            numIdxR[i]=numIdx[m+1+i];
            numSumR[i]=numSum[m+1+i];
        }

        int i=0;
        int j=0;
        int k=l;

        while(i<m-l+1&&j<r-m){
            if(numSumL[i]>=numSumR[j]){
                numSum[k]=numSumL[i];
                numIdx[k]=numIdxL[i];
                i++;
                k++;
            }else{
                numSum[k]=numSumR[j];
                numIdx[k]=numIdxR[j];
                j++;
                k++;
            }
        }

        while(i<m-l+1){
            numSum[k]=numSumL[i];
            numIdx[k]=numIdxL[i];
            i++;
            k++;
        }

        while(j<r-m){
            numSum[k]=numSumR[j];
            numIdx[k]=numIdxR[j];
            j++;
            k++;
        }

    }


    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numSumMap = new HashMap<>();
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            if (numSumMap.containsKey(nums[i])) {
                int sum=numSumMap.get(nums[i]);
                sum = sum+nums[i];
                numSumMap.put(nums[i],sum);
            } else {
                numSumMap.put(nums[i], nums[i] );
            }
        }

        int numSumMapLen=numSumMap.size();
        int[] numIdx=new int[numSumMapLen];
        int[] numSum=new int[numSumMapLen];

        Set<Map.Entry<Integer,Integer>> entries=numSumMap.entrySet();
        int i=0;
        for(Map.Entry<Integer,Integer> entry:entries){
            numIdx[i]=entry.getKey();
            numSum[i]=entry.getValue();
            i++;
        }

        mergeSort(numIdx,numSum,0,i-1);

        boolean[] deleted=new boolean[numSumMapLen];
        Arrays.fill(deleted,false);
        int deleteCount=0;

        while(deleteCount<numSumMapLen) {
            for (int j = 0; j <numSumMapLen;j++){
                if(!deleted[i]){
                    int earn=numSum[i];
                    int loss=0;

                }
            }
        }



//        Set<Integer> keySet = numSumMap.keySet();
//        List<NumWrap> list=new ArrayList<>();
//        for(int key:keySet){
//            list.add(new NumWrap(key,numSumMap.get(key)));
//        }
//        Collections.sort(list);
//
//        int point=0;
//        while(!keySet.isEmpty()) {
//            for (NumWrap nw : list) {
//                int earn=nw.sum;
//                int key=nw.number;
//                int loss=0;
//                if (numSumMap.containsKey(key - 1)) {
//                    loss += numSumMap.get(key - 1) ;
//                }
//                if (numSumMap.containsKey(key + 1)) {
//                    loss += numSumMap.get(key + 1) ;
//                }
//                if (earn > loss) {
//                    point += earn;
//                    keySet.remove(key - 1);
//                    keySet.remove(key);
//                    keySet.remove(key + 1);
//                    break;
//                }
//            }
//        }


//
//        int point = 0;
//        while (!keySet.isEmpty()) {
//
//            for (int key : keySet) {
//                int loss = 0;
//                if (numSumMap.containsKey(key - 1)) {
//                    loss += numSumMap.get(key - 1) ;
//                }
//                if (numSumMap.containsKey(key + 1)) {
//                    loss += numSumMap.get(key + 1) ;
//                }
//                int earn = numSumMap.get(key) ;
//                if (earn > loss) {
//                    point += earn;
//                    keySet.remove(key - 1);
//                    keySet.remove(key);
//                    keySet.remove(key + 1);
//                    break;
//                }
//            }
//        }
//

        return 0;
    }
}


