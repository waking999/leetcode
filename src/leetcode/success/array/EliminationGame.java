package leetcode.success.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/elimination-game/description/
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * <p>
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * <p>
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * <p>
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * Output:
 * 6
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }

        int count = n;
        int step = 1;
        boolean isLeft = true;
        int start = 1;
        while (count > 1) {


            if (isLeft || count % 2 == 1) {
                start += step ;
            }
            step *=2 ;
            count/= 2;
            isLeft = !isLeft;
        }

        return start;
    }




}
