package lintcode.google.level1;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example
 * Given intervals => merged intervals:
 * <p>
 * [                     [
 * (1, 3),               (1, 6),
 * (2, 6),      =>       (8, 10),
 * (8, 10),              (15, 18)
 * (15, 18)            ]
 * ]
 * Challenge
 * O(n log n) time and O(1) extra space.
 */
public class MergeIntervals {
    private final static char START = '[';
    private final static char END = ']';



    /**
     * @param intervals: interval list.
     * @return A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        int intervalsLen = intervals.size();
        if (intervalsLen < 2) {
            return intervals;
        }

        int[] seqNum = new int[intervalsLen + intervalsLen];
        char[] seqLab = new char[intervalsLen + intervalsLen];

        int seqCount = 0;
        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            if (start != end) {
                seqCount = insertOnDiffStartEnd(seqNum, seqLab, seqCount, start, START);
                seqCount = insertOnDiffStartEnd(seqNum, seqLab, seqCount, end, END);
            } else {
                int exist = exist(seqNum, seqCount, start);
                if (exist == 0) {
                    //not exist
                    seqCount = insertOnSameStartEnd(seqNum, seqLab, seqCount, start, START);
                    seqCount = insertOnSameStartEnd(seqNum, seqLab, seqCount, end, END);
                }
            }
        }
        //use a stack to match start/end
        Stack<Integer> s = new Stack<>();
        List<Interval> rtn = new ArrayList<>();
        for (int i = 0; i < seqCount; i++) {
            if (seqLab[i] == START) {
                s.push(i);
            } else {
                int startPos = s.pop();
                if (s.isEmpty()) {
                    int end = seqNum[i];
                    int start = seqNum[startPos];
                    rtn.add(new Interval(start, end));
                }
            }
        }
        return rtn;
    }

    private int exist(int[] valArray, int currentNum, int val) {
        int count = 0;
        for (int i = 0; i < currentNum; i++) {
            if (valArray[i] > val) {
                break;
            }
            if (valArray[i] == val) {
                count++;
            }
        }
        return count;
    }

    int insertOnSameStartEnd(int[] valArray, char[] labArray, int currentNum, int value, char lab) {
        int pos = currentNum;

        for (int i = 0; i < currentNum; i++) {

            if (value < valArray[i]) {
                pos = i;
                for (int j = currentNum - 1; j >= i; j--) {
                    valArray[j + 1] = valArray[j];
                    labArray[j + 1] = labArray[j];
                }
                break;
            }
        }
        valArray[pos] = value;
        labArray[pos] = lab;
        currentNum++;
        return currentNum;

    }

    int insertOnDiffStartEnd(int[] valArray, char[] labArray, int currentNum, int value, char lab) {
        int pos = currentNum;
        boolean eq = false;
        for (int i = 0; i < currentNum; i++) {
            if (value == valArray[i] && lab != labArray[i]) {
                //if an existing end (start) meets a new start (end) of the same value, remove both of them
                eq = true;
                pos = i;
                break;
            }
            if (value < valArray[i]) {
                pos = i;
                for (int j = currentNum - 1; j >= i; j--) {
                    valArray[j + 1] = valArray[j];
                    labArray[j + 1] = labArray[j];
                }
                break;
            }
        }
        if (!eq) {
            valArray[pos] = value;
            labArray[pos] = lab;
            currentNum++;
            return currentNum;
        } else {
            //remove the same value for the start(end)/end(start);
            for (int i = pos; i < currentNum - 1; i++) {
                valArray[i] = valArray[i + 1];
                labArray[i] = labArray[i + 1];
            }
            currentNum--;
            return currentNum;
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}


