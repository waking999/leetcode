package leetcode.success.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

import leetcode.success.comm.Util;

public class Pow {
	private double myPow(double x, int n) {
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
			ret=bd.setScale(5,RoundingMode.HALF_UP).doubleValue();
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
			ret=bd.setScale(5,RoundingMode.HALF_UP).doubleValue();
//			ret = bd.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();


			return ret;

		}
	}

	public static void main(String[] args) {
		Pow s = new Pow();

		double x;
		int n;
		double expect;
		double output;

		x = 2.0;
		n = 2;
		expect = 4.0;
		output = s.myPow(x, n);
		Util.verify(expect, output, 1);

		x = 34.00515;
		n = -3;
		expect = 0.00003;
		output = s.myPow(x, n);
		Util.verify(expect, output, 2);

		x = -13.62608;
		n = 3;
		expect = -2529.95504;
		output = s.myPow(x, n);
		Util.verify(expect, output, 3);

		x = 2;

		n = -2147483648;
		expect = 0.0000;
		output = s.myPow(x, n);
		Util.verify(expect, output, 4);

	}

}
