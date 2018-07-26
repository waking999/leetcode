package leetcode.pending.dp;

/**
 * https://leetcode.com/problems/2-keys-keyboard/description/
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 * <p>
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 * <p>
 * Example 1:
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * Note:
 * The n will be in the range [1, 1000].
 */
public class TwoKeysKeyboard {
    private int currentTextCount;
    private int clipboardCount;
    private int numOfCopyOp;
    private int numOfPasteOp;

    private void copyAll() {
        clipboardCount = currentTextCount;
        numOfCopyOp++;
    }

    private void paste() {
        currentTextCount += clipboardCount;
        numOfPasteOp++;
    }


    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return n;
        }

        currentTextCount = 2;
        clipboardCount = 1;
        numOfCopyOp = 1;
        numOfPasteOp = 1;

        while (currentTextCount < n) {
            int val = currentTextCount <<1;
            /*
             * copy current text and paste
             * condition 1: the target is the multiple of currentTextCount -> n % currentTextCount == 0
             * condition 2: a. the target is the multiple of 2*currentTextCount since the copy operation will change the clipboardCount
             *                 and we need to asure the changed clipboardCount can be used for future paste to achieve n  => n% (2currentTextCount)==0
             *           or b. if the n is not the multiple of 2*currentTextCount (i.e. n is odd multiple of currentTextCount),
             *              b.1 if currentTextCount is odd, say 9, and n is 27, 27 is 3*9, 3 is odd, we should copy to change the clipboardCount from 3 to 9
             *                  since if we don't copy and only paste, the currentTextCount will be 9+3=12, 27 is not multiple of 12,
             *                  and we have to repeat pasting until 27, which needs more steps;
             *              b.2 if currentTexCount is even, say 8, and n is 24, 24 is 3*8, 8 is even, we can paste first to make the currentTextCount to be 8+4=12
             *                  and 24 is still multiple of 12, and then we apply copy & paste later, which will save steps
             */
            if ((n % val == 0 || currentTextCount % 2 == 1) && n % currentTextCount == 0){
                copyAll();
                paste();
            } else{
                paste();
            }
        }

        return numOfCopyOp + numOfPasteOp;
    }
}
