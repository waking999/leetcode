package leetcode.success.math;

/**
 * https://leetcode.com/contest/weekly-contest-92/problems/prime-palindrome/
 * <p>
 * Find the smallest prime palindrome greater than or equal to N.
 * <p>
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
 * <p>
 * For example, 2,3,5,7,11 and 13 are primes.
 * <p>
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
 * <p>
 * For example, 12321 is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: 7
 * Example 2:
 * <p>
 * Input: 8
 * Output: 11
 * Example 3:
 * <p>
 * Input: 13
 * Output: 101
 * <p>
 * 1 <= N <= 10^8
 * The answer is guaranteed to exist and be less than 2 * 10^8.
 */
public class PrimePalindrome {
    private final static int IMPOSSIBLE_VALUE = -1;
    boolean found;

    public int primePalindrome(int N) {
        if (N <= 2) {
            return 2;
        }
        if (N == 3) {
            return 3;
        }
        if (N <= 5) {
            return 5;
        }
        if (N <= 7) {
            return 7;
        }
        if (N <= 11) {
            return 11;
        }
        if (N <= 101) {
            return 101;
        }

        //get how many digits of the input and the first digit

        int numOfDigitsOfN = 0;
        int p = N;
        int first = N;
        while (p > 0) {
            first = p;
            numOfDigitsOfN++;
            p /= 10;
        }


        //if the first is even, we should start from the next odd
        if (first % 2 == 0) {
            first++;
        }


        while (true) {
            //construct a qualified number;
            int number = constructPalinPrime(N, first, numOfDigitsOfN);
            if (number!=IMPOSSIBLE_VALUE) {
                return number;
            }
            //if we can't find a qualified number starting from the first digits, we go to next odd
            first += 2;
            //if the first digits is bigger than 9, we need to start over from 1 as the first digit but the number of digits should increase
            if (first > 9) {
                numOfDigitsOfN++;
                first = 1;
            }
        }

    }

    /**
     * construct palindrome number
     *
     * @param N, the palindrome and prime number should be bigger than or equals to N
     * @param first, the first digit of the palindrome
     * @param length, the length of the palindrome
     * @return return the number if its a palindrome and also a prime
     */
    private int constructPalinPrime(int N, int first, int length) {

        //we need to fill the digits in the middle, for example x0x1x2 for 3x0x1x23, the x0x1 will be between 0 and maxTry
        int expectDigitsCount = (length - 1) / 2;
        int maxTry = 1;
        int p = 0;
        while (p < expectDigitsCount) {
            maxTry *= 10;
            p++;
        }

        //we construct a number with left half middle being filled with a number between 0 and maxTry
        for (int i = 0; i < maxTry; i++) {
            //we convert a certain try: x0x1x2 to an array such that we can calculate expected number digit by digit
            int[] tries = getTries(i, expectDigitsCount);

            int number = first;
            //with left half middle being filled with a number between 0 and maxTry
            for (int j = 0; j < expectDigitsCount; j++) {
                number =  number * 10+tries[j];

            }

            //if length is odd, the format may like the example of x0x1x2, at this moment, x0x1 is filled, we only need to fill x2, which is the same as x0;
            //if length is even, the format may like the example of x0x1x2x3, at this moment, x0x1 is filled, we need to fill x2x3 which is the same as x1x0;
            int j = expectDigitsCount-1;
            if (length % 2 != 0) {
               j--;
            }

            for ( ; j >= 0; j--) {
                number =  number * 10+tries[j];
            }
            number =  number * 10+first;


            //we get a palindrome number here
            if (number >= N) {
                if (isPrime(number)) {
                    //if it is a prime, it is what we look for
                    found = true;
                    return number;
                }
            }
        }

        return IMPOSSIBLE_VALUE;

    }

    /**
     * is n prime?
     *
     * @param n, a number
     * @return true is; false no;
     */
    private boolean isPrime(int n) {
        //let n mod by 2 to its square root, if the mod is 0, it means it is not a prime
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }



    private int[] getTries(int aTry, int tryLen) {
        int[] rtn = new int[tryLen];

        for (int i = tryLen - 1; i >= 0; i--) {
            rtn[i] = aTry % 10;
            aTry /= 10;
        }

        return rtn;
    }

}
