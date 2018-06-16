package lintcode.google.level1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.Util.verifyUnsort;


public class MergeIntervalsTest {
    private static List<Interval> convertArrayToList(int[][] array) {
        List<Interval> rtn = new ArrayList<>();
        for (int[] anArray : array) {
            rtn.add(new Interval(anArray[0], anArray[1]));
        }
        return rtn;
    }

    @Test
    public void testInsert() {
        MergeIntervals s = new MergeIntervals();

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
        s.insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 's');
        expect = new int[]{5};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        verifyUnsort(expect, output, seq++);

        currentNum++;
        value = 8;
        s.insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 'e');
        expect = new int[]{5, 8};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        verifyUnsort(expect, output, seq++);

        currentNum++;
        value = 3;
        s.insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 's');
        expect = new int[]{3, 5, 8};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        verifyUnsort(expect, output, seq++);

        currentNum++;
        value = 4;
        s.insertOnDiffStartEnd(seqNum, seqLab, currentNum, value, 'e');
        expect = new int[]{3, 4, 5, 8};
        output = Arrays.copyOf(seqNum, currentNum + 1);
        verifyUnsort(expect, output, seq++);

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
}
