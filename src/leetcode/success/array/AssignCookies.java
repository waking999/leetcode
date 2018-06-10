package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		
		int i=0;
		int j=0;
		int count=0;
		while(i<g.length&&j<s.length){
			if(g[i]<=s[j]){
				i++;
				j++;
				count++;
			}else{
				j++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		AssignCookies s = new AssignCookies();

		int[] k;
		int[] c;
		int expect;
		int output;

		k = new int[] { 1, 2, 3 };
		c = new int[] { 1, 1 };
		expect = 1;
		output = s.findContentChildren(k, c);
		Util.verify(expect, output, 1);

		k = new int[] { 1, 2 };
		c = new int[] { 1, 2, 3 };
		expect = 2;
		output = s.findContentChildren(k, c);
		Util.verify(expect, output, 2);

		System.out.println("Finish");

	}

}
