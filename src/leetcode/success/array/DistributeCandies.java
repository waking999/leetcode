package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;

public class DistributeCandies {
	public int distributeCandies(int[] candies) {
		if(candies==null) {
			return 0;
		}
		int candiesLen=candies.length;
		if(candiesLen==0) {
			return 0;
		}
		Arrays.sort(candies);
		int kind=0;
		for(int i=0;i<candiesLen;i++) {
			if(i==0||candies[i]!=candies[i-1]) {
				kind++;
			}
		}
		return Math.min(kind, candiesLen/2);
		
	}

	public static void main(String[] args) {
		DistributeCandies s=new DistributeCandies();
		
		int[] candies;
		int expect;
		int output;
		
		candies=new int[] {1,1,2,2,3,3};
		expect=3;
		output=s.distributeCandies(candies);
		Util.verify(expect, output, 1);
		
		candies=new int[] {1,1,2,3};
		expect=2;
		output=s.distributeCandies(candies);
		Util.verify(expect, output, 2);
		
		

	}

}
