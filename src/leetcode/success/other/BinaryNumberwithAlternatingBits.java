package leetcode.success.other;

public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int comp = 1 - n % 2;
        n = n / 2;

        while (n != 0) {
            int a = n % 2;
            if (comp != a) {
                return false;
            }
            comp = 1 - a;
            n = n / 2;
        }

        return true;
    }


}
