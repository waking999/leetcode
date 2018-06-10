package leetcode.success.nowhere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		int list1Len = list1.length;
		int list2Len = list2.length;
		if (list1Len == 0 || list2Len == 0) {
			return new String[] {};
		}
		Map<String, Integer> strIdxSumMap = new HashMap<String, Integer>();
		for (int i = 0; i < list1Len; i++) {
			strIdxSumMap.put(list1[i], i + 1);
		}

		for (int i = 0; i < list2Len; i++) {
			if (strIdxSumMap.containsKey(list2[i])) {
				strIdxSumMap.put(list2[i], 0 - strIdxSumMap.get(list2[i]) - i - 1);
			}
		}

		Set<String> keySet = strIdxSumMap.keySet();

		int maxIdx = Integer.MIN_VALUE;

		for (String s : keySet) {
			int idxSum = strIdxSumMap.get(s);
			if (idxSum <= 0) {
				if (maxIdx <= idxSum) {
					maxIdx = idxSum;
				}
			}
		}

		List<String> result = new ArrayList<String>();
		String[] resultArray = {};

		for (String s : keySet) {
			int idxSum = strIdxSumMap.get(s);
			if (idxSum == maxIdx) {
				result.add(s);
			}
		}

		return result.toArray(resultArray);

	}

	public static void main(String[] args) {
		MinimumIndexSumOfTwoLists s = new MinimumIndexSumOfTwoLists();

		String[] list1;
		String[] list2;
		String[] expect;
		String[] output;
		int expectLen;
		int outputLen;

		list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		list2 = new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
		expect = new String[] { "Shogun" };
		output = s.findRestaurant(list1, list2);
		expectLen = expect.length;
		outputLen = output.length;
		assert (expectLen == outputLen) : "1.wrong";
		Arrays.sort(expect);
		Arrays.sort(output);
		for (int i = 0; i < expectLen; i++) {
			assert (expect[i].equals(output[i])) : "1.wrong";
		}

		list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		list2 = new String[] { "KFC", "Shogun", "Burger King" };
		expect = new String[] { "Shogun" };
		output = s.findRestaurant(list1, list2);
		expectLen = expect.length;
		outputLen = output.length;
		assert (expectLen == outputLen) : "2.wrong";
		Arrays.sort(expect);
		Arrays.sort(output);
		for (int i = 0; i < expectLen; i++) {
			assert (expect[i].equals(output[i])) : "2.wrong";
		}

		list1 = new String[] { "Shogun", "KFC", "Tapioca Express", "Burger King" };
		list2 = new String[] { "KFC", "Shogun", "Burger King" };
		expect = new String[] { "Shogun", "KFC" };
		output = s.findRestaurant(list1, list2);
		expectLen = expect.length;
		outputLen = output.length;
		assert (expectLen == outputLen) : "3.wrong";
		Arrays.sort(expect);
		Arrays.sort(output);
		for (int i = 0; i < expectLen; i++) {
			assert (expect[i].equals(output[i])) : "3.wrong";
		}

		list1 = new String[] { "vacag", "KFC" };
		list2 = new String[] { "fvo", "xrljq", "jrl", "KFC" };
		expect = new String[] { "KFC" };
		output = s.findRestaurant(list1, list2);
		expectLen = expect.length;
		outputLen = output.length;
		assert (expectLen == outputLen) : "3.wrong";
		Arrays.sort(expect);
		Arrays.sort(output);
		for (int i = 0; i < expectLen; i++) {
			assert (expect[i].equals(output[i])) : "3.wrong";
		}

		System.out.println("Finish");

	}

}
