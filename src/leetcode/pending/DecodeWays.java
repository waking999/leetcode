package leetcode.pending;

/**
 * https://leetcode.com/problems/decode-ways/description/
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    private static final int IMPOSSIBLE_VALUE = -1;
    private int count;

    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        int sLen = s.length();
        char[] chars = s.toCharArray();
        if (sLen == 0) {
            return 0;
        }
        if (chars[0] == '0') {
            return 0;
        }
        if (sLen == 1) {
            return 1;
        }

        count = 0;

        dfs(chars, sLen, 0, 0);
        dfs(chars, sLen, 0, 1);
        return count;
    }

    private void dfs(char[] chars, int sLen, int start, int end) {
        if (end >= sLen) {
            return;
        }

        if (start == sLen - 1 && end == sLen - 1 && chars[start] != '0') {
            count++;
            return;
        }
        if (start == sLen - 2 && end == sLen - 1) {
            int val = validVal(chars, start, end);
            if (val != IMPOSSIBLE_VALUE) {
                count++;
            }
            return;
        }

        int step1 = 1;
        if (start != end) {
            //2 digits
            step1 = 2;
        }
        int step2 = step1 + 1;

        int val = validVal(chars, start, end);
        if (val != IMPOSSIBLE_VALUE) {
            dfs(chars, sLen, start + step1, start + step1);
            dfs(chars, sLen, start + step1, start + step2);
        }

    }

    private int validVal(char[] chars, int start, int end) {
        if (start == end) {
            int val = chars[start] - '0';
            return val > 0 ? val : IMPOSSIBLE_VALUE;
        } else {
            int v1 = chars[start] - '0';
            if (v1 == 0 || v1 > 2) {
                return IMPOSSIBLE_VALUE;
            }
            int v2 = chars[end] - '0';
            int val = v1 * 10 + v2;
            return val > 26 ? IMPOSSIBLE_VALUE : val;
        }
    }
}

