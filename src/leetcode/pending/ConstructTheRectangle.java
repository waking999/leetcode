package leetcode.pending;

import leetcode.success.comm.Util;

public class ConstructTheRectangle {
	public int[] constructRectangle(int area) {
		int r=1;
		for(int i=1;i*i<=area;i++) {
			if(area%i==0) {
				r=i;
			}
		}
		return new int[] {area/r,r};
	}

	public static void main(String[] args) {
		ConstructTheRectangle s = new ConstructTheRectangle();

		int area;
		int[] expect;
		int[] output;

		area = 4;
		expect = new int[] { 2, 2 };
		output = s.constructRectangle(area);
		Util.verifySort(expect, output, 1);

	}

}
