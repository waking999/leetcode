package leetcode.attempt;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return 0 - dividend;
            }
        }
        long d1 = (long) dividend;


        if (Math.abs(d1) < Math.abs(divisor)) {
            return 0;
        }

        if (d1 == divisor) {
            return 1;
        }

        if (d1 + divisor == 0) {
            return -1;
        }

        boolean dividendPos = d1 == Math.abs(d1);
        boolean divisordPos = divisor == Math.abs(divisor);


        d1 = Math.abs(d1);
        divisor = Math.abs(divisor);

        int count = -1;
        while (d1 >= 0) {
            d1 -= divisor;
            count++;
        }
        if (dividendPos == divisordPos) {
            return count;
        } else {
            return 0 - count;
        }


    }


}
