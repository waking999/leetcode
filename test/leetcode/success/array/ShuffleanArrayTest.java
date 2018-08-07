package leetcode.success.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ShuffleanArrayTest {
    @Test
    public void test1() {
        int[] nums;
        ShuffleanArray s;
        int[] output;
        String outputStr;
        int seq = 1;

        nums = new int[]{1, 2, 3};
        s = new ShuffleanArray(nums);
        output = s.shuffle();
        outputStr = Arrays.stream(output).sorted().boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        if ("1,2,3".equals(outputStr) || "1,3,2".equals(outputStr) || "2,1,3".equals(outputStr)
                || "2,3,1".equals(outputStr) || "3,1,2".equals(outputStr) || "3,2,1".equals(outputStr)) {

        } else {
            Assertions.assertTrue(false, seq + " wrong.");
            seq++;
        }

        s.reset();
        if ("1,2,3".equals(outputStr) ) {

        } else {
            Assertions.assertTrue(false, seq + " wrong.");
            seq++;
        }

        output = s.shuffle();
        outputStr = Arrays.stream(output).sorted().boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        if ("1,2,3".equals(outputStr) || "1,3,2".equals(outputStr) || "2,1,3".equals(outputStr)
                || "2,3,1".equals(outputStr) || "3,1,2".equals(outputStr) || "3,2,1".equals(outputStr)) {

        } else {
            Assertions.assertTrue(false, seq + " wrong.");
            seq++;
        }
    }
}
