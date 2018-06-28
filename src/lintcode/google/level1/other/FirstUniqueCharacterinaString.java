package lintcode.google.level1.other;

import java.util.Arrays;

/**
 * Description
 * Find the first unique character in a given string. You can assume that there is at least one unique character in the string.
 *
 *
 * Example
 * For "abaccdeff", return 'b'.
 */
public class FirstUniqueCharacterinaString {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        int[] charCount=new int[256];
        Arrays.fill(charCount,0);

        char[] chars=str.toCharArray();
        for(char ch:chars){
            charCount[ch]++;
        }

        for(char ch:chars){
            if(charCount[ch]==1){
                return ch;
            }
        }

        return 0;
    }
}
