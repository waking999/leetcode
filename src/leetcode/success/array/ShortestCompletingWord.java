package leetcode.success.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/shortest-completing-word/description/
 * <p>
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
 * <p>
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * <p>
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * <p>
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 * <p>
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        int sLen = licensePlate.length();
        char[] chArr = new char[sLen];
        licensePlate = licensePlate.toLowerCase();
        int chArrLen = 0;
        for (int i = 0; i < sLen; i++) {
            char ch = licensePlate.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                chArr[chArrLen++] = ch;
            }
        }


        List<WordWrap> wordList = new ArrayList<>();
        int wordsLen = words.length;
        for (int i = 0; i < wordsLen; i++) {
            wordList.add(new WordWrap(words[i], i));
        }
        Collections.sort(wordList);


        for (WordWrap ww : wordList) {
            List<Character> wordChars = ww.wordChars;
            int i = 0;
            for (i = 0; i < chArrLen; i++) {
                if (wordChars.contains(chArr[i])) {
                    remove(wordChars,chArr[i]);
                } else {
                    break;
                }
            }
            if (i == chArrLen) {
                return ww.word;
            }
        }
        return null;
    }

    private boolean remove(List<Character> wordChars,char ch){
        for(Character wordChar:wordChars){
            if(wordChar==ch){
                wordChars.remove(wordChar);
                return true;
            }
        }
        return false;
    }

    class WordWrap implements Comparable<WordWrap> {
        String word;
        List<Character> wordChars;
        int wordLen;
        int index;


        WordWrap(String word, int index) {
            this.word = word;
            wordLen = word.length();
            wordChars = new ArrayList<>(wordLen);
            for (int i = 0; i < wordLen; i++) {
                wordChars.add(word.charAt(i));
            }
            this.index = index;
        }

        @Override
        public int compareTo(WordWrap b) {

            if (this.wordLen == b.wordLen) {
                return this.index - b.index;
            } else {
                return this.wordLen - b.wordLen;
            }
        }

    }
}
