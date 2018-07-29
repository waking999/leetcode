package leetcode.attempt;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/profitable-schemes/description/
 * <p>
 * There are G people in a gang, and a list of various crimes they could commit.
 * <p>
 * The i-th crime generates a profit[i] and requires group[i] gang members to participate.
 * <p>
 * If a gang member participates in one crime, that member can't participate in another crime.
 * <p>
 * Let's call a profitable scheme any subset of these crimes that generates at least P profit, and the total number of gang members participating in that subset of crimes is at most G.
 * <p>
 * How many schemes can be chosen?  Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: G = 5, P = 3, group = [2,2], profit = [2,3]
 * Output: 2
 * Explanation:
 * To make a profit of at least 3, the gang could either commit crimes 0 and 1, or just crime 1.
 * In total, there are 2 schemes.
 * Example 2:
 * <p>
 * Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
 * Output: 7
 * Explanation:
 * To make a profit of at least 5, the gang could commit any crimes, as long as they commit one.
 * There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= G <= 100
 * 0 <= P <= 100
 * 1 <= group[i] <= 100
 * 0 <= profit[i] <= 100
 * 1 <= group.length = profit.length <= 100
 */
public class ProfitableSchemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int profileLen = profit.length;

        total = 0;
        for (int r = 1; r <= profileLen; r++) {
            int profileData[] = new int[r];
            int groupData[] = new int[r];
            combin(G, P, profileData, groupData, 0, profileLen-1, 0, r, profit, group);
        }
        return total;
    }

    private int total;

    private void combin(int G, int P, int[] profitData, int[] groupData, int start, int end, int index, int r, int[] profit, int[] group) {
        if (index == r) {
            int profitSum = 0;
            int groupSum = 0;
            for (int i = 0; i < r; i++) {
                profitSum += profitData[i];
                groupSum += groupData[i];
                if(groupSum>G){
                    return;
                }
            }
            if(profitSum<P){
                return;
            }
            if (profitSum >= P && groupSum <= G) {
                total++;
                if (total >= 1000000007) {
                    total = total % 1000000007;
                }
            }
            return;
        }
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            profitData[index] = profit[i];
            groupData[index] = group[i];
            combin(G, P, profitData, groupData, i + 1, end, index + 1, r, profit, group);
        }

    }
}
