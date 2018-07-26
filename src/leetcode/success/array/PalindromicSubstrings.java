package leetcode.success.array;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 * iven a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s==null){
            return 0;
        }
        int sLen=s.length();
        if(sLen==0){
            return 0;
        }
        if(sLen==1){
            return 1;
        }

        int count=0;
        char[] chs=s.toCharArray();
        for(int i=0;i<sLen;i++){
            for(int j=i;j<sLen;j++){
                 if(isPalindromic(chs,i,j)){
                     count++;
                 }
            }
        }


        return count;
    }

    private boolean isPalindromic(char[] chs,int i,int j){
        int m=(j-i)/2;
        for(int k=0;k<=m;k++){
            if(chs[i+k]!=chs[j-k]){
                return false;
            }
        }
        return true;
    }
}
