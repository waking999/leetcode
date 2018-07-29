package leetcode.attempt;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/description/
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        return false;
    }
//    public boolean checkInclusion(String s1, String s2) {
//        if (s1 == null) {
//            return true;
//        }
//        if (s2 == null) {
//            return false;
//        }
//        int s1Len = s1.length();
//
//        if (s1Len == 0) {
//            return true;
//        }
//        if (s1Len == 1) {
//            if (s2.contains(s1)) {
//                return true;
//            }
//        }
//        int s2Len = s2.length();
//        if (s2Len < s1Len) {
//            return false;
//        }
//        char[] chs = s1.toCharArray();
//        if (s1Len == s2Len) {
//            int[] s1Count = getCount(chs);
//            int[] s2Count = getCount(s2.toCharArray());
//            for (int i=0;i<26;i++) {
//                if (s1Count[i] != s2Count[i]) {
//                    return false;
//                }
//            }
//        }
//
//
//        found = false;
//        permuation(chs, 0, s1Len, s2);
//
//        return found;
//    }
//
//    private boolean found;
//
//    private void permuation(char[] chs, int start, int chLen, String s2) {
//        if (start == chLen - 1) {
//            String s1 = new String(chs);
//
//            if (s2.contains(s1)) {
//                found = true;
//            }
//        } else {
//            for (int i = start; i < chLen; i++) {
//                swap(chs, start, i);
//                permuation(chs, start + 1, chLen, s2);
//                if (found) {
//                    return;
//                }
//                swap(chs, start, i);
//            }
//        }
//
//    }
//
//    private void swap(char[] chs, int i, int j) {
//        char tmp = chs[i];
//        chs[i] = chs[j];
//        chs[j] = tmp;
//    }
//
//    private int[] getCount(char[] chs) {
//        int[] count = new int[26];
//        Arrays.fill(count, 0);
//        for (char ch : chs) {
//            count[ch - 'a']++;
//        }
//        return count;
//
//    }


}
