package history;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {

        Set<Integer> historyNum = new HashSet<>();

        while (true) {
            n = digitPower(n);
            if (n == 1)
                return true;
            if (historyNum.contains(n)) {
                return false;
            } else {
                historyNum.add(n);
            }
        }


    }

    int digitPower(int n) {

        int sum = 0;
        do {
            int m = n % 10;
            n = (n - m) / 10;
            sum += m * m;
        } while (n != 0);

        return sum;
    }


}
