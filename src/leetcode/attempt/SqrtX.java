package leetcode.attempt;

public class SqrtX {
    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        int l = 0, h = x;

        while (true) {
            int m = l + (h - l) / 2;
            int n = x / m;
            if (m <= n) {
                return m;
            } else {
                l = n;
                h = m;
            }
        }

    }


}
