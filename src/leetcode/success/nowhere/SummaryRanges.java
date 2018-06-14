package leetcode.success.nowhere;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {		
		
		List<String> summary = new ArrayList<>();
		if(nums.length==0){
			return summary;
		}
		
		int start = nums[0];
		int end = nums[0];
		int pointer = 0;
		for (int i = 1; i < nums.length; i++) {
			if ((nums[i] - nums[pointer]) == 1) {
				end = nums[i];
				pointer++;
			} else {
				String s;
				if (start == end) {
					s = Integer.toString(start);
				} else {
					s = start + "->" + end;
				}
				summary.add(s);

				start = nums[i];
				end = nums[i];
				pointer = i;
			}

		}
		String s;
		if (start == end) {
			s = Integer.toString(start);
		} else {
			s = start + "->" + end;
		}
		summary.add(s);
		return summary;
	}

	@Test
	public void test1() {
		int[] input = { 0, 1, 2, 4, 5, 7 };
		String[] expect = { "0->2", "4->5", "7" };

		SummaryRanges s = new SummaryRanges();
		List<String> outputList = s.summaryRanges(input);
		Object[] output = outputList.toArray();

		for (int i = 0; i < expect.length; i++) {
			String s1 = expect[i];
			String s2 = (String) output[i];
			assert (s1.equals(s2));
		}

		input = new int[] { 0, 2, 3, 4, 6, 8, 9 };
		expect = new String[] { "0", "2->4", "6", "8->9" };

		outputList = s.summaryRanges(input);
		output = outputList.toArray();

		for (int i = 0; i < expect.length; i++) {
			String s1 = expect[i];
			String s2 = (String) output[i];
			assert (s1.equals(s2));
		}
		
		input = new int[] {};
		expect = new String[] {};

		outputList = s.summaryRanges(input);
		output = outputList.toArray();

		for (int i = 0; i < expect.length; i++) {
			String s1 = expect[i];
			String s2 = (String) output[i];
			assert (s1.equals(s2));
		}
	}
}
