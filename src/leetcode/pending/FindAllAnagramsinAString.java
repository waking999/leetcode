package leetcode.pending;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinAString {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[256];

        char[] pChars = p.toCharArray();
        int pLen = p.length();

        for (char c : pChars) {
            hash[c]++;
        }

        int left = 0, right = 0, count = pLen;
        char[] sChars = s.toCharArray();
        int sLen = s.length();

        while (right < sLen) {
            if (hash[sChars[right]] >= 1) {
                count--;
            }
            hash[sChars[right]]--;
            right++;

            if (count == 0) {
                list.add(left);
            }

            if (right - left == pLen) {

                if (hash[sChars[left]] >= 0) {
                    count++;
                }
                hash[sChars[left]]++;
                left++;
            }
        }
        return list;
    }


}
