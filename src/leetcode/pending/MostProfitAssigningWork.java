package leetcode.pending;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/most-profit-assigning-work/description/
 * <p>
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.
 * <p>
 * Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].
 * <p>
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 * <p>
 * For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.
 * <p>
 * What is the most profit we can make?
 * <p>
 * Example 1:
 * <p>
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * Output: 100
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
 * Notes:
 * <p>
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int diffLen = difficulty.length;
        Job[] jobs = new Job[diffLen];
        for (int i = 0; i < diffLen; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs);

        int sumMax = 0;
        for (int compacity : worker) {
            sumMax += maxProfitPerWorker(jobs, compacity);
        }
        return sumMax;
    }

    /**
     * get the first job whose difficulty  greater than the key
     */
    private int binarySearch(Job[] jobs, int key, int l, int r) {
        if (r < l || key > jobs[r].difficulty) {
            return jobs.length;
        }
        if (key < jobs[l].difficulty) {
            return l;
        }
        if (l == r) {
            return l+1;
        } else {
            int m = l + (r - l) / 2;
            if (jobs[m].difficulty < key) {
                return binarySearch(jobs, key, m + 1, r);
            } else {
                return binarySearch(jobs, key, l, m);
            }
        }
    }

    private int maxProfitPerWorker(Job[] jobs, int compacity) {
        int lastIdx = jobs.length - 1;
        int jobPos = this.binarySearch(jobs, compacity, 0, lastIdx);
        int end=jobPos;


        if (jobPos == lastIdx+1) {
            end=lastIdx;
        }else if(jobPos==0) {
                end = -1;
        }else{
            if (jobs[jobPos].difficulty == compacity) {
                end=jobPos;
            } else {
                end=jobPos - 1;
            }
        }
        int max=0;
        for(int i=0;i<=end;i++){
            max=Math.max(max,jobs[i].profit);
        }

        return max;
    }

    class Job implements Comparable<Job> {
        int difficulty;
        int profit;

        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job b) {
            if (b == null) {
                return 1;
            }
           if( this.difficulty == b.difficulty){
                return this.profit-b.profit;
           }else{
                return this.difficulty-b.difficulty;
           }
        }
    }

}
