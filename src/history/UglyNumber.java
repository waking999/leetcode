package history;

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;

        if ((num <= 6) && (num >= 1))
            return true;

        while (num != 1) {
            int m = num % 2;
            if (m == 0) {
                num = num / 2;
            } else {
                m = num % 3;
                if (m == 0) {
                    num = num / 3;
                } else {
                    m = num % 5;
                    if (m == 0) {
                        num = num / 5;
                    } else {
                        return false;
                    }
                }
            }

        }

        return true;
    }


}
