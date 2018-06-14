package leetcode.attempt;


public class IntegerReplacement {
    public int integerReplacement(int n) {

        return branch((long) n, 0);
    }


    private int branch(long n, int count) {
        if (n == 1 || n == 0) {
            return 0;
        }
        if (n == 2) {
            return count + 1;
        }
        if (n % 2 == 0) {
            return branch(n >> 1, count + 1);
        }
        return Math.min(branch(n + 1, count + 1), branch(n - 1, count + 1));
    }


}
