package leetcode.success.array;

public class GuessNumberHigherOrLower {
    int real;

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g == 1) {

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param num, your guess
     * @return -1 if my number is lower, 1 if my number is higher, otherwise
     * return 0
     */
    private int guess(int num) {
        return Integer.compare(real, num);
    }


}
