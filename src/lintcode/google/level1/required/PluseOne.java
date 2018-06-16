package lintcode.google.level1.required;

/**
 * Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example
 * Given [1,2,3] which represents 123, return [1,2,4].
 * <p>
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 */
public class PluseOne {
    /**
     * @param digits: a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }


}
