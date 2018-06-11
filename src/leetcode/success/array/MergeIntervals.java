package leetcode.success.array;



import leetcode.success.comm.Util;
import org.junit.Test;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
    private final static char START = '[';
    private final static char END = ']';

    public List<Interval> merge(List<Interval> intervals) {
        int intervalsLen = intervals.size();
        if (intervalsLen < 2) {
            return intervals;
        }

        int[] seqNum = new int[intervalsLen + intervalsLen];
        char[] seqLab = new char[intervalsLen + intervalsLen];

        int seqCount = 0;
        for (int i = 0; i < intervalsLen; i++) {
            Interval interval = intervals.get(i);
            int start = interval.start;
            int end = interval.end;
            if (start != end) {
                seqCount = insertOnDiffStartEnd(seqNum, seqLab, seqCount, start, START);
                seqCount = insertOnDiffStartEnd(seqNum, seqLab, seqCount, end, END);
            } else {
                int exist=exist(seqNum, seqCount, start);
                if(exist==0){
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
        int count=0;
        for (int i = 0; i < currentNum; i++) {
            if(valArray[i]>val){
                break;
            }
            if (valArray[i] == val) {
                count++;
            }
        }
        return count;
    }

    private int insertOnSameStartEnd(int[] valArray, char[] labArray, int currentNum, int value, char lab) {
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

    private int insertOnDiffStartEnd(int[] valArray, char[] labArray, int currentNum, int value, char lab) {
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


    @Test
    public void testInsert() {
        int[] seqNum;
        char[] seqLab;
        int currentNum;
        int value;
        int seq = 0;
        int[] expect;
        int[] output;

        seqNum = new int[8];
        seqLab = new char[8];
        Arrays.fill(seqNum, -1);
        Arrays.fill(seqLab, '0');

        currentNum = 0;
        value = 5;
        insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 's');
        expect = new int[]{5};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        Util.verifyUnsort(expect, output, seq++);

        currentNum++;
        value = 8;
        insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 'e');
        expect = new int[]{5, 8};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        Util.verifyUnsort(expect, output, seq++);

        currentNum++;
        value = 3;
        insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 's');
        expect = new int[]{3, 5, 8};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        Util.verifyUnsort(expect, output, seq++);

        currentNum++;
        value = 4;
        insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 'e');
        expect = new int[]{3, 4, 5, 8};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        Util.verifyUnsort(expect, output, seq++);

    }


    @Test
    public void testmerge() {
        MergeIntervals s = new MergeIntervals();

        int[][] intervalsArray;
        List<Interval> intervals;
        int[][] expect;
        List<Interval> output;
        int seq = 0;

        intervalsArray = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        expect = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{1, 4}, {4, 5}};
        expect = new int[][]{{1, 5}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{1, 3}};
        expect = new int[][]{{1, 3}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{1, 4}, {5, 6}};
        expect = new int[][]{{1, 4}, {5, 6}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{1, 4}, {0, 4}};
        expect = new int[][]{{0, 4}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{1, 4}, {0, 1}};
        expect = new int[][]{{0, 4}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{1, 4}, {2, 3}};
        expect = new int[][]{{1, 4}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);


        intervalsArray = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        expect = new int[][]{{0, 5}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{1, 4}, {0, 0}};
        expect = new int[][]{{1, 4}, {0, 0}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);


        intervalsArray = new int[][]{{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}};
        expect = new int[][]{{0, 3}, {4, 6}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);

        intervalsArray = new int[][]{{4, 4}, {3, 5}, {2, 3}, {1, 1}, {3, 3}, {1, 3}, {2, 2}, {0, 0}, {5, 5}, {0, 0}, {4, 6}};
        expect = new int[][]{{0, 0}, {1, 6}};
        intervals = convertArrayToList(intervalsArray);
        output = s.merge(intervals);
        System.out.print(seq++);
    }

    private static List<Interval> convertArrayToList(int[][] array) {
        List<Interval> rtn = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            rtn.add(new Interval(array[i][0], array[i][1]));
        }
        return rtn;
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


