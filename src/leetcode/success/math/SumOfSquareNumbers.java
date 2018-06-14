package leetcode.success.math;

import static leetcode.success.comm.Util.verify;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        SumOfSquareNumbers s = new SumOfSquareNumbers();

        int c;
        boolean expect;
        boolean output;

        c = 5;
        expect = true;
        output = s.judgeSquareSum(c);
        verify(expect, output, 1);
    }

    public boolean judgeSquareSum(int c) {
        int a = (int) Math.sqrt(c);
        for (int i = a; i >= 0; i--) {
            if (a * a == c) {
                return true;
            }
            int d = c - i * i;
            int b = (int) Math.sqrt(d);
            if (b * b == d) {
                return true;
            }
        }
        return false;
    }

}
