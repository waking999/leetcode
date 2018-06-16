package lintcode.google.level1.required;

/**
 * Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * Example
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    /**
     * @param s: A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        if (s.isEmpty()) {
            return true;
        }
        int sSize = s.length();
        char[] chars = s.toCharArray();

        char[] cStack = new char[sSize];
        int cStackLen = 0;
        cStack[0] = chars[0];
        cStackLen++;

        int i = 1;
        while (i < sSize) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {

                cStack[cStackLen++] = chars[i];
                i++;
            } else {
                if (cStackLen == 0) {
                    return false;
                }
                char cTop = cStack[cStackLen - 1];
                if ((cTop == '(' && chars[i] == ')') || (cTop == '[' && chars[i] == ']')
                        || (cTop == '{' && chars[i] == '}')) {
                    cStackLen--;
                    i++;
                } else {
                    return false;
                }
            }
        }
        return cStackLen == 0;
    }


}
