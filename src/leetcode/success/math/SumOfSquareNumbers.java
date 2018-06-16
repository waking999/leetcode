package leetcode.success.math;


public class SumOfSquareNumbers {


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
