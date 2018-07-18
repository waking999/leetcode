package leetcode.attempt;

/**
 * https://leetcode.com/problems/reach-a-number/description/
 *
 * You are standing at position 0 on an infinite number line. There is a goal at position target.
 *
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 *
 * Return the minimum number of steps required to reach the destination.
 *
 * Example 1:
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * Example 2:
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9].
 */
public class ReachaNumber {
    public int reachNumber(int target) {

        found=false;
        step(0,1, target,true);
        if(!found) {
            step(0,1,target,false);
        }
        return finalStep;
    }

    private int finalStep;
    private boolean found;
    private void step(int currentPos,int nth, int target, boolean toRight){
        if(currentPos+nth==target||currentPos-nth==target){
            finalStep=nth;
            found=true;
            return;
        }
        if(currentPos+nth>target){
            //to right: fail, to left
            step(currentPos-nth,nth+1,target,false);
        }else{
            //to right
            step(currentPos+1,nth+1,target,true);
        }

        if(!found){
            if(currentPos-nth<0-target){
                //to left:failed, to right
                step(currentPos+nth,nth+1,target,true);
            }else{
                //to right
                step(currentPos-nth,nth+1,target,false);
            }

        }

    }
}
