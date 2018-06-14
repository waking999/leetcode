package lintcode.google.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 * <p>
 * Example
 * Given s = "++++", after one move, it may become one of the following states:
 * <p>
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 * If there is no valid move, return an empty list [].
 */
public class FlipGame {
    /**
     * @param s: the given string
     * @return all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        if (s == null) {
            return null;
        }

        List<String> set = new ArrayList<>();
        int sLen = s.length();
        if (s.length() < 2) {
            return set;
        }

        for (int i = 0; i < sLen - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String newStr = s.substring(0, i) + "--" + s.substring(i + 2);
                set.add(newStr);
            }
        }


        return set;
    }


}
