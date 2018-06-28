package leetcode.success.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/score-of-parentheses/description/
 * <p>
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 * <p>
 * Note:
 * <p>
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */
public class ScoreofParentheses {
    public int scoreOfParentheses(String S) {
        if (S == null) {
            return 0;
        }
        int sLen = S.length();
        if (sLen == 0) {
            return 0;
        }

        char[] chars = S.toCharArray();
        int charsLen = chars.length;


        Stack<Character> cStack = new Stack<>();

        int[] lvlScore = new int[charsLen / 2 + 1];

        for (char aChar : chars) {
            if (aChar == '(') {
                cStack.push('(');
            } else {
                int level = cStack.size() - 1;
                if (lvlScore[level + 1] == 0) {
                    lvlScore[level] += 1;
                } else {
                    lvlScore[level] = 2 * lvlScore[level + 1] + lvlScore[level];
                    lvlScore[level + 1] = 0;
                }

                cStack.pop();

            }
        }


        return lvlScore[0];

    }
}
