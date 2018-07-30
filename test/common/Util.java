package common;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    private final static double DIFF = 0.0000000000001;

    public static void verifySortedInOut(int[][] expect, List<List<Integer>> output, int seq) {
        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String[] expectOut = new String[expectLen];
        String[] outputOut = new String[expectLen];
        for (int i = 0; i < expectLen; i++) {
            String s1 = IntStream.of(expect[i]).boxed().sorted().collect(Collectors.toList()).stream()
                    .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
            expectOut[i] = s1;
            String s2 = output.get(i).stream().sorted().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
            outputOut[i] = s2;

        }
        Arrays.sort(expectOut);
        Arrays.sort(outputOut);
        for (int i = 0; i < expectLen; i++) {
            Assertions.assertEquals(expectOut[i], outputOut[i], seq + ":wrong");
        }

    }

    public static void verifySortedInOut(String[][] expect, List<List<String>> output, int seq) {
        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String[] expectOut = new String[expectLen];
        String[] outputOut = new String[expectLen];
        for (int i = 0; i < expectLen; i++) {
            String s1 = Arrays.stream(expect[i]).sorted().collect(Collectors.joining(","));
            expectOut[i] = s1;
            String s2 = output.get(i).stream().sorted().collect(Collectors.joining(","));
            outputOut[i] = s2;

        }
        Arrays.sort(expectOut);
        Arrays.sort(outputOut);
        for (int i = 0; i < expectLen; i++) {
            assert (expectOut[i].equals(outputOut[i])) : seq + ":wrong";
        }

    }


    public static void verifyUnsort(int[][] expect, List<List<Integer>> output, int seq) {
        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        for (int i = 0; i < expectLen; i++) {
            String s1 = IntStream.of(expect[i]).boxed().collect(Collectors.toList()).stream()
                    .map(num -> Integer.toString(num)).collect(Collectors.joining(","));

            String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
            assert (s1.equals(s2)) : seq + ":wrong";
        }
    }

    public static void verifyUnsort(String[][] expect, List<List<String>> output, int seq) {
        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        for (int i = 0; i < expectLen; i++) {
            String s1 = String.join(",", Arrays.stream(expect[i]).collect(Collectors.toList()));
            String s2 = String.join(",", output.get(i));
            Assertions.assertEquals(s1, s2, seq + ":wrong");
        }
    }

    public static void verifyUnsort(List<List<Integer>> expect, List<List<Integer>> output, int seq) {
        int expectLen = expect.size();
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        for (int i = 0; i < expectLen; i++) {
            String s1 = expect.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
            String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
            assert (s1.equals(s2)) : seq + ":wrong";
        }
    }

    public static void verifyUnsort(int[][] expect, int[][] output, int seq) {
        int expectLen = expect.length;
        int outputSize = output.length;
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        for (int i = 0; i < expectLen; i++) {
            String s1 = Arrays.stream(expect[i]).boxed().collect(Collectors.toList()).stream()
                    .map(num -> Integer.toString(num)).collect(Collectors.joining(","));

            String s2 = Arrays.stream(output[i]).boxed().collect(Collectors.toList()).stream()
                    .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
            assert (s1.equals(s2)) : seq + ":wrong";
        }

    }

    public static void verifyUnsort(String[] expect, List<String> output, int seq) {
        if (expect == null && output == null) {
            return;
        }
        Assertions.assertNotNull(expect);
        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String expectStr = String.join(",", expect);
        String outputStr = String.join(",", output);
        Assertions.assertEquals(expectStr,outputStr, seq + ":wrong");
    }

    public static void verifyUnsort(String[] expect, String[] output, int seq) {

        int expectLen = expect.length;
        int outputSize = output.length;
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String expectStr = String.join(",", expect);
        String outputStr = String.join(",", output);
        Assertions.assertEquals(expectStr,outputStr, seq + ":wrong");
    }

    public static void verifySort(int[] expect, List<Integer> output, int seq) {

        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String expectStr = Arrays.stream(expect).sorted().boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        String outputStr = output.stream().sorted().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        Assertions.assertEquals(expectStr,outputStr, seq + ":wrong");
    }

    public static void verifyUnsort(int[] expect, List<Integer> output, int seq) {
        if (expect == null && output == null) {
            return;
        }
        Assertions.assertNotNull(expect);
        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String expectStr = Arrays.stream(expect).boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        String outputStr = output.stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        Assertions.assertEquals(expectStr,outputStr, seq + ":wrong");
    }


    public static void verifyUnsort(Integer[] expect, List<Integer> output, int seq) {
        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        for (int i = 0; i < expectLen; i++)
            if (expect[i] == null && output.get(i) == null) {
            } else if (expect[i] != null) {
                Assertions.assertEquals(expect[i], output.get(i), seq + ":wrong");
            } else {
                Assertions.assertEquals(expect[i], output.get(i), seq + ":wrong");
            }


    }

    public static void verifyUnsort(double[] expect, List<Double> output, int seq) {

        int expectLen = expect.length;
        int outputSize = output.size();
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        for (int i = 0; i < expectLen; i++) {
            Assertions.assertTrue(Math.abs(expect[i] - output.get(i)) < DIFF, seq + ":wrong");
        }

    }

    public static void verifyUnsort(int[] expect, Integer[] output, int seq) {

        int expectLen = expect.length;
        int outputSize = output.length;
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String expectStr = Arrays.stream(expect).sorted().boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        String outputStr = Arrays.stream(output).sorted().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        assert (expectStr.equals(outputStr)) : seq + ":wrong";
    }

//	public static void verify(int[] expect, int[] output, int seq) {
//
//		int expectLen = expect.length;
//		int outputSize = output.length;
//		assert (expectLen == outputSize) : seq + ":wrong";
//		String expectStr = Arrays.stream(expect).sorted().boxed().collect(Collectors.toList()).stream()
//				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
//		String outputStr = Arrays.stream(output).sorted().boxed().collect(Collectors.toList()).stream()
//				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
//		assert (expectStr.equals(outputStr)) : seq + ":wrong";
//	}

    public static void verifyUnsort(char[] expect, char[] output, int seq) {

        int expectLen = expect.length;
        int outputSize = output.length;
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");

        String expectStr = new String(expect);
        String outputStr = new String(output);
        assert (expectStr.equals(outputStr)) : seq + ":wrong";
    }

    public static void verifySort(int[] expect, int[] output, int seq) {

        int expectLen = expect.length;
        int outputSize = output.length;
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String expectStr = Arrays.stream(expect).sorted().boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        String outputStr = Arrays.stream(output).sorted().boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        assert (expectStr.equals(outputStr)) : seq + ":wrong";
    }

    public static void verifyUnsort(int[] expect, int[] output, int seq) {

        int expectLen = expect.length;
        int outputSize = output.length;
        Assertions.assertEquals(expectLen, outputSize, seq + ":wrong");
        String expectStr = Arrays.stream(expect).boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));
        String outputStr = Arrays.stream(output).boxed().collect(Collectors.toList()).stream()
                .map(num -> Integer.toString(num)).collect(Collectors.joining(","));

        Assertions.assertEquals(expectStr, outputStr, seq + ":wrong");
    }


    public static void verify(int expect, int output, int seq) {

        Assertions.assertEquals(expect, output, seq + ":wrong");
    }

    public static void verify(double expect, double output, int seq) {
        Assertions.assertTrue(Math.abs(expect - output) <= DIFF, seq + ":wrong");
    }

    public static void verify(boolean expect, boolean output, int seq) {
        Assertions.assertEquals(expect, output, seq + ":wrong");
    }

    public static void verify(String expect, String output, int seq) {
        Assertions.assertEquals(expect, output, seq + ":wrong");
    }
}
