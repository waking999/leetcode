package lintcode.google.level2.required;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implement pow(x, n).
 */
public class Pow {
    private final static double DIFF = 0.000000001;

    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        if (Math.abs(x - 0) <= DIFF) {
            return 0;
        }
        if (Math.abs(x - 1) <= DIFF) {
            return 1;
        }
        if (Math.abs(x + 1) <= DIFF) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (n == 0) {
            return 1;
        }

        double rtn = 1.0;
        if (n > 0) {
            while (n > 0) {
                rtn *= x;
                if (Math.abs(rtn) <= DIFF) {
                    return 0;
                }
                n--;
            }
        } else {
            long t = Math.abs((long) (n));
            while (t > 0) {
                rtn /= x;
                if (Math.abs(rtn) <= DIFF) {
                    return 0;
                }

                t--;
            }

        }
        BigDecimal bd = new BigDecimal(rtn);
        rtn = bd.setScale(5, RoundingMode.HALF_UP).doubleValue();

        return rtn;
    }
}
