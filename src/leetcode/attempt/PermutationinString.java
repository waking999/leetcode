package leetcode.attempt;

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
        if (s1 == null) {
            return true;
        }
        if (s2 == null) {
            return false;
        }
        int s1Len = s1.length();
        if (s1Len == 0) {
            return true;
        }
        if (s1Len == 1) {
            return s2.contains(s1);
        }

        char[] chs = s1.toCharArray();
        boolean[] chosen = new boolean[s1Len];
        StringBuilder sb = new StringBuilder();


        found = false;
        for (int i = 0; i < s1Len; i++) {
            if (!found) {
                chosen[i] = true;
                sb.append(chs[i]);
                helper(sb, s1Len, chs, 0, chosen, s2);
                chosen[i] = false;
                sb.setLength(sb.length() - 1);
                if (found) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean found;

    private void helper(StringBuilder sb, int chsLen, char[] chs, int i, boolean[] chosen, String s2) {
        if (sb.length() == chsLen) {
            if (s2.contains(sb)) {
                found = true;
                return;
            }
        }
        if (!found) {
            int unchosenPos = getUnChosenPos(chosen, chsLen, i + 1);
            if (unchosenPos != -1) {
                sb.append(chs[unchosenPos]);
                chosen[unchosenPos] = true;
                helper(sb, chsLen, chs, i + 1, chosen, s2);
                chosen[unchosenPos] = false;
                sb.setLength(sb.length() - 1);
            }
        }

    }

    private int getUnChosenPos(boolean[] chosen, int len, int from) {
        for (int i = from; i < len; i++) {
            if (!chosen[i]) {
                return i;
            }
        }

        for (int i = 0; i < from; i++) {
            if (!chosen[i]) {
                return i;
            }
        }
        return -1;
    }
}
