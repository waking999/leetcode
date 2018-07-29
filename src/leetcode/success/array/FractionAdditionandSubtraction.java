package leetcode.success.array;

/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/description/
 * Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.
 * <p>
 * Example 1:
 * Input:"-1/2+1/2"
 * Output: "0/1"
 * Example 2:
 * Input:"-1/2+1/2+1/3"
 * Output: "1/3"
 * Example 3:
 * Input:"1/3-1/2"
 * Output: "-1/6"
 * Example 4:
 * Input:"5/3+1/3"
 * Output: "2/1"
 * Note:
 * The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
 * Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
 * The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
 * The number of given fractions will be in the range [1,10].
 * The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
 */
public class FractionAdditionandSubtraction {

    private static final String MINUS_STR = "-";
    private static final char FRAC_CH = '/';
    private static final String FRAC_STR = "/";

    private int[] numerators;
    private int[] denominators;
    private int numOf;

    private void getDenominator(char[] chs, int chLen) {
        numerators = new int[chLen];
        denominators = new int[chLen];
        numOf = 0;
        int fracPos = getFracPos(chs, chLen, 0);
        while (fracPos != -1) {
            int numeratorStart = getNumeratorStart(chs, fracPos);
            int denominatorEnd = getDenominatorEnd(chs, chLen, fracPos);
            int numerator = getNumerator(chs, numeratorStart, fracPos - 1);
            int denominator = getDenominator(chs, fracPos + 1, denominatorEnd);
            numerators[numOf] = numerator;
            denominators[numOf] = denominator;
            numOf++;
            fracPos = getFracPos(chs, chLen, denominatorEnd + 3);

        }


    }

    private int getNumerator(char[] chs, int start, int end) {
        int num = getNum(chs, start, end);
        if (start == 0) {
            return num;
        }
        char sign = chs[start - 1];


        return sign == '+' ? num : (0 - num);
    }

    private int getDenominator(char[] chs, int start, int end) {
        int num = getNum(chs, start, end);
        return num;
    }

    private int getNum(char[] chs, int start, int end) {
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + (chs[i] - '0');
        }
        return num;
    }


    private int getDenominatorEnd(char[] chs, int chLen, int fracPos) {
        int i = fracPos + 1;
        while (i < chLen && (chs[i] >= '0' && chs[i] <= '9')) {
            i++;
        }
        return i - 1;
    }

    private int getNumeratorStart(char[] chs, int fracPos) {
        int i = fracPos - 1;
        while (i >= 0 && (chs[i] >= '0' && chs[i] <= '9')) {
            i--;
        }
        return i + 1;

    }

    private int minCommonMultiple() {
        long m = denominators[0];
        for (int i = 1; i < numOf; i++) {
            m *= denominators[i];
        }

        return (int) (m / maxCommonDivisor());
    }


    private int maxCommonDivisor() {
        int m = denominators[0];
        for (int i = 1; i < numOf; i++) {
            int n = denominators[i];
            m = maxCommonDivisor(m, n);
        }
        return m;
    }

    private int maxCommonDivisor(int m, int n) {

        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    private int getFracPos(char[] ch, int chLen, int from) {
        for (int i = from; i < chLen; i++) {
            if (ch[i] == FRAC_CH) {
                return i;
            }
        }
        return -1;
    }

    public String fractionAddition(String expression) {

        char[] chs = expression.toCharArray();
        int chLen = chs.length;
        getDenominator(chs, chLen);
        if(numOf==1){
            return expression;
        }
        int mcm = minCommonMultiple();

        int totalNumerator = 0;

        for (int i = 0; i < numOf; i++) {
            totalNumerator += numerators[i] * mcm / denominators[i];
        }
        if (totalNumerator == 0) {
            return "0/1";
        }
        int mcd = maxCommonDivisor(Math.abs(totalNumerator), mcm);
        int numerator = totalNumerator / mcd;
        int denominator = mcm / mcd;
        return numerator + FRAC_STR + denominator;


    }
}
