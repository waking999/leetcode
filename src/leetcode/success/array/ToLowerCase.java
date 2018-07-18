package leetcode.success.array;

/**
 * https://leetcode.com/problems/to-lower-case/description/
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: "here"
 * Output: "here"
 * Example 3:
 *
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if(str==null){
            return null;
        }

        int sLen=str.length();
        if(sLen==0){
            return str;
        }
        char[] chars=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char ch:chars){
            if(ch>=65&&ch<=90){
                sb.append((char)(ch-'A'+'a'));
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
