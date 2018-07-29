package leetcode.success.array;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 * <p>
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * <p>
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordinDictionarythroughDeleting {
    class Wrap implements Comparable<Wrap> {
        char[] chs;
        int chsLen;

        Wrap(String str) {
            this.chs = str.toCharArray();
            this.chsLen = str.length();
        }

        @Override
        public int compareTo(Wrap b) {
            if (this.chsLen != b.chsLen) {
                return b.chsLen - this.chsLen;
            }

            return compare(this.chs, b.chs);
        }

        private int compare(char[] chs1,char[] chs2){
            int chs1Len=chs1.length;
            int chs2Len=chs2.length;
            if(chs1Len!=chs2Len){
                return chs2Len-chs1Len;
            }
            for(int i=0;i<chs1Len;i++){
                if(chs1[i]!=chs2[i]){
                    return chs1[i]-chs2[i];
                }
            }
            return 0;
        }


    }


    private boolean find2In1(char[] chs1, int chsLen1, char[] chs2, int chsLen2) {

        int p2 = 0;
        int p1 = 0;
        while (p2 < chsLen2&&p1<chsLen1) {
            if (chs2[p2] == chs1[p1]) {
                p1++;
                p2++;
            } else {
                p1++;
            }

        }
        if (p1 >= chsLen1&&p2<chsLen2) {
            return false;
        }
        if(p2==chsLen2){
            return true;
        }

        return false;

    }

    public String findLongestWord(String s, List<String> d) {

        int sLen = s.length();


        int dLen = d.size();
        Wrap[] dict = new Wrap[dLen];
        int dicSize = 0;
        for (String str : d) {
            if (str.length() <= sLen) {
                dict[dicSize++] = new Wrap(str);
            }
        }
        Wrap[] newDict = Arrays.copyOfRange(dict, 0, dicSize);

        Arrays.sort(newDict);

        for (Wrap w : newDict) {
            char[] wChs = w.chs;
            int wChsLen = w.chsLen;
            boolean found = find2In1(s.toCharArray(), sLen, wChs, wChsLen);
            if (found) {
                return new String(wChs);
            }

        }

        return "";
    }
}
