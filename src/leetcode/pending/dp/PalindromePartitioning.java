package leetcode.pending.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    private List<List<String>> lists;

    public List<List<String>> partition(String s) {
        if (s == null) {
            return null;
        }
        int sLen = s.length();
        lists = new ArrayList<>();
        if (sLen == 0) {
            return lists;
        }
        if (sLen == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            lists.add(list);
            return lists;
        }
        char[] chars = s.toCharArray();

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= sLen; i++) {
            dfs(chars, sLen, 0, i, list);
        }

        return lists;
    }

    /**
     * recursive method
     *
     * @param chars,    the char array of the string
     * @param charsLen, chars length
     * @param l,        left boundary, included
     * @param r,        right boundary, not included
     * @param list,     a list in middle step to accommodate temporary result
     */
    private void dfs(char[] chars, int charsLen, int l, int r, List<String> list) {
        if (r > charsLen) {
            return;
        }

        boolean isPalindrome = true;
        int mid = (r - 1 - l) / 2;
        for (int i = 0; i <= mid; i++) {
            if (chars[l + i] != chars[r - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        if (!isPalindrome) {
            return;
        }
        char[] tmpChars = Arrays.copyOfRange(chars, l, r);
        String tmpStr = new String(tmpChars);
        list.add(tmpStr);

        if (r >= charsLen) {
            int listLen = list.size();
            List<String> tmpList = new ArrayList<>(Arrays.asList(new String[listLen]));
            Collections.copy(tmpList, list);
            lists.add(tmpList);
            list.remove(tmpStr);
            return;
        }

        for (int i = r + 1; i <= charsLen; i++) {
            dfs(chars, charsLen, r, i, list);
        }
        list.remove(tmpStr);


    }
}
