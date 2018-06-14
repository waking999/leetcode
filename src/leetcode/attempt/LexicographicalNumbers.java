package leetcode.attempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.success.comm.Util;
import org.junit.Test;

public class LexicographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
		String[] arr=new String[n+1];
		for(int i=0;i<=n;i++) {
			arr[i]=Integer.toString(i);
		}
		Arrays.sort(arr);
 
		List<Integer> ret=new ArrayList<>();
		for(int i=1;i<n+1;i++) {
			ret.add(Integer.parseInt(arr[i]));
		}
		return ret;
	}


	@Test
	public void test1() {
		LexicographicalNumbers s = new LexicographicalNumbers();

		int n;
		int[] expect;
		List<Integer> output;
		int seq = 0;

		n = 13;
		expect = new int[] { 1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9 };
		output = s.lexicalOrder(n);
		Util.verifyUnsort(expect, output, seq);

	}

}
