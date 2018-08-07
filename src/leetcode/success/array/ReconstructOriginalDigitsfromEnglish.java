package leetcode.success.array;

/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * <p>
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * <p>
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * <p>
 * Output: "45"
 */
public class ReconstructOriginalDigitsfromEnglish {


    public String originalDigits(String s) {
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            charCount[ch - 'a']++;
        }

        int[] digitCount = new int[10];


        digitCount[0] = charCount['z'- 'a'];
        digitCount[1] = charCount['o'- 'a'] - charCount['z'- 'a'] - charCount['w'- 'a'] - charCount['u'- 'a'];
        digitCount[2] = charCount['w'- 'a'];
        digitCount[3] = charCount['h'- 'a'] - charCount['g'- 'a'];
        digitCount[4] = charCount['u'- 'a'];
        digitCount[5] = charCount['f'- 'a'] - charCount['u'- 'a'];
        digitCount[6] = charCount['x'- 'a'];
        digitCount[7] = charCount['s'- 'a'] - charCount['x'- 'a'];
        digitCount[8] = charCount['g'- 'a'];
        digitCount[9] = charCount['i'- 'a'] - digitCount[5] - digitCount[6] - digitCount[8];


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                sb.append(i);
            }
        }


        return sb.toString();
    }

}
