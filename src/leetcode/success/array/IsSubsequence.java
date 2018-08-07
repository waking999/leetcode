package leetcode.success.array;

/**
 * https://leetcode.com/problems/is-subsequence/description/
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * s = "abc", t = "ahbgdc"
 *
 * Return true.
 *
 * Example 2:
 * s = "axc", t = "ahbgdc"
 *
 * Return false.
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s==null){
            return true;
        }
        if(t==null){
            return false;
        }
        int sLen=s.length();
        int tLen=t.length();
        if(sLen>tLen){
            return false;
        }



        int sPointer=0;
        int tPointer=0;

        while(sPointer<sLen){
            tPointer = t.indexOf(s.charAt(sPointer), tPointer) + 1;
            if(tPointer == 0) {
                return false;
            }
            sPointer++;

        }

         return true;
    }
}