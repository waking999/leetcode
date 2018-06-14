package lintcode.google.level1;

/**
 * Given a sequence of words, check whether it forms a valid word square.
 * <p>
 * A sequence of words forms a valid word square if the k^th row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * <p>
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 * <p>
 * Example
 * Given
 * [
 * "abcd",
 * "bnrt",
 * "crmy",
 * "dtye"
 * ]
 * return true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crmy".
 * The fourth row and fourth column both read "dtye".
 * <p>
 * Therefore, it is a valid word square.
 * Given
 * [
 * "abcd",
 * "bnrt",
 * "crm",
 * "dt"
 * ]
 * return true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crm".
 * The fourth row and fourth column both read "dt".
 * <p>
 * Therefore, it is a valid word square.
 * Given
 * [
 * "ball",
 * "area",
 * "read",
 * "lady"
 * ]
 * return false
 * <p>
 * Explanation:
 * The third row reads "read" while the third column reads "lead".
 * <p>
 * Therefore, it is NOT a valid word square.
 */
public class ValidWordSquare {
    /**
     * A sequence of words forms a valid word square if the k^th row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
     *
     * @param words: a list of string
     * @return a boolean
     */
    public boolean validWordSquare(String[] words) {
        if (words == null) {
            return true;
        }
        int wordsLen = words.length;
        if (wordsLen <= 1) {
            return true;
        }


        for (int i = 0; i < wordsLen; i++) {
            String word = words[i];
            int wordLen = word.length();
            for (int j = 0; j < wordLen; j++) {
                if (word.charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }


        return true;
    }


}
