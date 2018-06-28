package leetcode.success.array;

import java.util.Arrays;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 *
 * Input: A = "", B = "aa"
 * Output: false
 *
 *
 * Note:
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A==null||B==null){
            return false;
        }
        int aLen=A.length();
        int bLen=B.length();

        if(aLen<2||bLen<2||aLen!=bLen){
            return false;
        }

        char[] aChars=A.toCharArray();
        char[] bChars=B.toCharArray();

        int left=-1;
        for(int i=0;i<aLen;i++){
            if(aChars[i]!=bChars[i]){
                left=i;
                break;
            }
        }
        if(left==-1){
            //it means A=B
            int[] chCount=new int[256];
            Arrays.fill(chCount,0);
            for(int i=0;i<aLen;i++){
                if(chCount[aChars[i]]>=1){
                    //if there exists repeated chars, we can simply swap them to satisfy condition, so return true
                    return true;
                }
                chCount[aChars[i]]++;
            }
            //if there does not exist repeated chars, condition can't be satisfied, false
            return false;
        }

        int right=aLen;
        for(int i=aLen-1;i>left;i--){
            if(aChars[i]!=bChars[i]){
                right=i;
                break;
            }
        }

        if(right==aLen){
            //only one different, can't swap
            return false;
        }

        for(int i=left+1;i<=right-1;i++){
            //if more than 2 differences, false
            if(aChars[i]!=bChars[i]){
                return false;
            }
        }

        return (aChars[left] == bChars[right]) && (aChars[right] == bChars[left]);


    }
}
