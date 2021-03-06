package leetcode.success.array;

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



}
