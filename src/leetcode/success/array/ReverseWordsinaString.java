package leetcode.success.array;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        s = s.trim();
        int sLen = s.length();
        if (sLen == 0) {
            return "";
        }
        String[] words = s.split(" ");
        int wordsLen = words.length;


        StringBuilder sb = new StringBuilder();
        for (int i = wordsLen - 1; i >= 0; i--) {
            if (!"".equals(words[i])) {
                sb.append(words[i]).append(" ");
            }
        }


        return sb.substring(0, sb.length() - 1);
    }
}
