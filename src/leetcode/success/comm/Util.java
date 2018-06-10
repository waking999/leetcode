package leetcode.success.comm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
	private final static double DIFF=0.0000000000001;
	public static void verify(int[][] expect, List<List<Integer>> output, int seq) {
		int expectLen = expect.length;
		int outputSize = output.size();
		assert (expectLen == outputSize) : seq + ":wrong";
		for (int i = 0; i < expectLen; i++) {
			String s1 = IntStream.of(expect[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));

			String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
			assert (s1.equals(s2)) : seq + "wrong";
		}

	}

	public static void verify(int[][] expect, int[][] output, int seq) {
		int expectLen = expect.length;
		int outputSize = output.length;
		assert (expectLen == outputSize) : seq + ":wrong";
		for (int i = 0; i < expectLen; i++) {
			String s1 = Arrays.stream(expect[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));

			String s2 = Arrays.stream(output[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
			assert (s1.equals(s2)) : seq + ":wrong";
		}

	}

	public static void verify(String[] expect, List<String> output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.size();
		assert (expectLen == outputSize) : seq + ":wrong";
		String expectStr = Arrays.asList(expect).stream().collect(Collectors.joining(","));
		String outputStr = output.stream().collect(Collectors.joining(","));
		assert (expectStr.equals(outputStr)) : seq + ":wrong";
	}
	
	public static void verify(String[] expect, String[] output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.length;
		assert (expectLen == outputSize) : seq + ":wrong";
		String expectStr = Arrays.asList(expect).stream().collect(Collectors.joining(","));
		String outputStr = Arrays.asList(output).stream().collect(Collectors.joining(","));
		assert (expectStr.equals(outputStr)) : seq + ":wrong";
	}

	public static void verifySort(int[] expect, List<Integer> output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.size();
		assert (expectLen == outputSize) : seq + ":wrong";
		String expectStr = Arrays.stream(expect).sorted().boxed().collect(Collectors.toList()).stream()
				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		String outputStr = output.stream().sorted().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		assert (expectStr.equals(outputStr)) : seq + ":wrong";
	}
	
	public static void verifyUnsort(int[] expect, List<Integer> output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.size();
		assert (expectLen == outputSize) : seq + ":wrong";
		String expectStr = Arrays.stream(expect).boxed().collect(Collectors.toList()).stream()
				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		String outputStr = output.stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		assert (expectStr.equals(outputStr)) : seq + ":wrong";
	}

	public static void verify(double[] expect, List<Double> output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.size();
		assert (expectLen == outputSize) : seq + ":wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (Math.abs(expect[i]-output.get(i))<DIFF) : seq + ":wrong";
		}

	}

	public static void verify(int[] expect, Integer[] output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.length;
		assert (expectLen == outputSize) : seq + ":wrong";
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
	
	public static void verify(char[] expect, char[] output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.length;
		assert (expectLen == outputSize) : seq + ":wrong";
		
		String expectStr = new String(expect);
		String outputStr = new String(output);
		assert (expectStr.equals(outputStr)) : seq + ":wrong";
	}

	public static void verifySort(int[] expect, int[] output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.length;
		assert (expectLen == outputSize) : seq + ":wrong";
		String expectStr = Arrays.stream(expect).sorted().boxed().collect(Collectors.toList()).stream()
				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		String outputStr = Arrays.stream(output).sorted().boxed().collect(Collectors.toList()).stream()
				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		assert (expectStr.equals(outputStr)) : seq + ":wrong";
	}
	
	public static void verifyUnsort(int[] expect, int[] output, int seq) {

		int expectLen = expect.length;
		int outputSize = output.length;
		assert (expectLen == outputSize) : seq + ":wrong";
		String expectStr = Arrays.stream(expect).boxed().collect(Collectors.toList()).stream()
				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		String outputStr = Arrays.stream(output).boxed().collect(Collectors.toList()).stream()
				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		assert (expectStr.equals(outputStr)) : seq + ":wrong";
	}
	

	
	public static void verify(int expect, int output, int seq) {
		assert (expect == output) : seq + ":wrong";
	}

	public static void verify(double expect, double output, int seq) {
		assert (Math.abs(expect - output) < DIFF ) : seq + ":wrong";
	}

	public static void verify(boolean expect, boolean output, int seq) {
		assert (expect == output) : seq + ":wrong";
	}

	public static void verify(String expect, String output, int seq) {
		assert (expect.equals(output)) : seq + ":wrong";
	}
}
