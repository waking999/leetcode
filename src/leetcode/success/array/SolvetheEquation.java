package leetcode.success.array;

/**
 * https://leetcode.com/problems/solve-the-equation/description/
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class SolvetheEquation {
    private static final String NO_SOLUTION = "No solution";
    private static final String INF_SOLUTION = "Infinite solutions";
    private static final String PREFIX = "x=";

    private int[] parse(String equation) {
        /*
         * result[0]: numberOfX;
         * result[1]: constant;
         */
        int numOfX = 0;
        int constant = 0;
        char[] chs = equation.toCharArray();
        int chsLen = chs.length;
        for (int i = 0; i < chsLen; i++) {

            if ((chs[i] == '+' || chs[i] == '-')) {
                int p = i + 1;
                int coefficient = 0;
                boolean coefficientExist = false;
                while ((p < chsLen) && (chs[p] != '+' && chs[p] != '-' && chs[p] != 'x')) {
                    coefficient = coefficient * 10 + (chs[p] - '0');
                    coefficientExist = true;
                    p++;
                }
                if (p < chsLen && chs[p] == 'x') {
                    if (coefficient == 0) {
                        if (coefficientExist) {
                            coefficient = 0;
                        } else {
                            coefficient = 1;
                        }
                    }

                    if (chs[i] == '+') {
                        numOfX += coefficient;
                    } else {
                        numOfX -= coefficient;
                    }
                    i = p;
                } else {
                    if (chs[i] == '+') {
                        constant += coefficient;
                    } else {
                        constant -= coefficient;
                    }
                    i = p - 1;
                }

            }

        }
        return new int[]{numOfX, constant};
    }

    public String solveEquation(String equation) {
        if (equation == null) {
            return NO_SOLUTION;
        }
        int equalSignPos = equation.indexOf('=');
        if (equalSignPos == -1) {
            return NO_SOLUTION;
        }
        String[] equationArray = equation.split("=");

        int[] left = parse("+" + equationArray[0]);
        int[] right = parse("+" + equationArray[1]);
        int numOfX = left[0] - right[0];
        int constant = right[1] - left[1];
        if (numOfX == 0 && constant == 0) {
            return INF_SOLUTION;
        }
        if (numOfX == 0) {
            return NO_SOLUTION;
        }
        if (constant == 0) {
            return "x=0";
        }
        return PREFIX + (constant / numOfX);
    }
}
