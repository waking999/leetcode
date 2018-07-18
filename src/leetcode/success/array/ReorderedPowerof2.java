package leetcode.success.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reordered-power-of-2/description/
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Example 2:
 * <p>
 * Input: 10
 * Output: false
 * Example 3:
 * <p>
 * Input: 16
 * Output: true
 * Example 4:
 * <p>
 * Input: 24
 * Output: false
 * Example 5:
 * <p>
 * Input: 46
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 */
public class ReorderedPowerof2 {

    public boolean reorderedPowerOf2(int N) {

        Array nArray = getDigits(N);
        int[] nDigits = nArray.digits;
        int nDigitsCount = nArray.digitsCount;
        int[] nDigitsPure = Arrays.copyOfRange(nDigits, 0, nDigitsCount);

        String nDigitsPureStr = Arrays.stream(nDigitsPure).sorted().boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));

        int range = 3;
        if ((nDigitsCount - 1) % 3 == 0) {
            range = 4;
        }
        int acculateRangeSinceMod = 0;
        if ((nDigitsCount - 1) % 3 == 1){
            acculateRangeSinceMod=4;
        }else if ((nDigitsCount - 1) % 3 == 2){
            acculateRangeSinceMod=7;
        }
        int rangeStart = ((nDigitsCount - 1) / 3) * 10 + acculateRangeSinceMod;


        for (int i = 0; i < range; i++) {
            int p = (int) Math.pow(2, rangeStart + i);
            if(p==N){
                return true;
            }
            Array powerArray = getDigits(p);
            int[] pDigits = powerArray.digits;
            int[] pDigitsPure = Arrays.copyOfRange(pDigits, 0, nDigitsCount);
            String pDigitsPureStr = Arrays.stream(pDigitsPure).sorted().boxed().collect(Collectors.toList()).stream()
                    .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
            if (pDigitsPureStr.equals(nDigitsPureStr)) {
                return true;
            }
        }


        return false;
    }


    private Array getDigits(int N) {

        int[] array = new int[10];

        int arrayLen = 0;
        while (N > 0) {
            array[arrayLen++] = N % 10;
            N = N / 10;
        }

        return new Array(array, arrayLen);
    }

    class Array {
        int[] digits;
        int digitsCount;

        Array(int[] digits, int arrayLen) {
            this.digits = digits;
            this.digitsCount = arrayLen;
        }
    }
}
