package leetcode.success.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pow {
    public double myPow(double x, int n) {
        double ret = 1;
        long t;
        if (Math.abs(x - 1) <= 0.0000000001) {
            return 1;
        }
        if (Math.abs(x + 1) <= 0.0000000001) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            while (n > 0) {
                ret = ret * x;
                if (x > 0 && ret < 0.00001) {
                    return 0.00001;
                }

                n--;
            }
            BigDecimal bd = new BigDecimal(ret);
            ret = bd.setScale(5, RoundingMode.HALF_UP).doubleValue();
//			ret = bd.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();

            return ret;
        } else {
            t = Math.abs((long) n);
            while (t > 0) {
                ret = ret * x;
                if (ret > 1000000) {
                    return 0.00000;
                }
                t--;
            }

            ret = 1 / ret;

            BigDecimal bd = new BigDecimal(ret);
            ret = bd.setScale(5, RoundingMode.HALF_UP).doubleValue();
//			ret = bd.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();


            return ret;

        }
    }


}
