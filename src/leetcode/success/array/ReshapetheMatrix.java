package leetcode.success.array;

import leetcode.success.comm.Util;

public class ReshapetheMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums==null) {
			return null;
		}
		int nR=nums.length;
		if(nR==0) {
			return null;
		}
		int nC=nums[0].length;
		if(nC==0) {
			return null;
		}
		if(nR*nC!=r*c) {
			return nums;
		}
		
		int[][] ret=new int[r][c];
		for(int i=0;i<nR;i++) {
			for(int j=0;j<nC;j++) {
				int pos=i*nC+j;
				int nI=pos/c;
				int nJ=pos%c;
				ret[nI][nJ]=nums[i][j];
			}
		}
		
		return ret;
		
	}

	public static void main(String[] args) {
		ReshapetheMatrix s = new ReshapetheMatrix();

		int[][] nums;
		int r;
		int c;
		int[][] expect;
		int[][] output;

		nums = new int[][] { { 1, 2 }, { 3, 4 } };
		r = 1;
		c = 4;
		expect = new int[][] { { 1, 2, 3, 4 } };
		output=s.matrixReshape(nums, r, c);
		Util.verify(expect, output, 1);
		
		nums = new int[][] { { 1, 2 }, { 3, 4 } };
		r = 2;
		c = 4;
		expect = new int[][] { { 1, 2 }, { 3, 4 } };
		output=s.matrixReshape(nums, r, c);
		Util.verify(expect, output, 2);
	}

}
