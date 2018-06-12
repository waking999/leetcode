package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
		if(M==null) {
			return M;
		}
		int mRowNum=M.length;
		if(mRowNum==0) {
			return null;
		}
		int mColNum=M[0].length;
		if(mColNum==0) {
			return null;
		}
	 
		
		int[][] ret=new int[mRowNum][mColNum];
		for(int i=0;i<mRowNum;i++) {
			for(int j=0;j<mColNum;j++) {
				int sum=0;
				int count=1;
				sum=M[i][j];
				if(j+1<mColNum){
					sum+=M[i][j+1];
					count++;
				}
				if(j-1>=0) {
					sum+=M[i][j-1];
					count++;					 
				}
				if(i-1>=0) {
					sum+=M[i-1][j];
					count++;	
					if(j-1>=0) {
						sum+=M[i-1][j-1];
						count++;
					}
					if(j+1<mColNum) {
						sum+=M[i-1][j+1];
						count++;
					}
				}
				if(i+1<mRowNum) {
					sum+=M[i+1][j];
					count++;
					if(j-1>=0) {
						sum+=M[i+1][j-1];
						count++;
					}
					if(j+1<mColNum) {
						sum+=M[i+1][j+1];
						count++;
					}
				}
				
				
					
				ret[i][j]=(int)Math.floor(sum*1.0/count);
			}
		}
		
		
		
		return ret;
	}

    @Test
    public void test1() {
		ImageSmoother s = new ImageSmoother();

		int[][] M;
		int[][] expect;
		int[][] output;

		M = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		expect = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		output=s.imageSmoother(M);
		Util.verifyUnsort(expect, output, 1);
		
		M = new int[][] { { 1 } };
		expect = new int[][] { { 1} };
		output=s.imageSmoother(M);
		Util.verifyUnsort(expect, output,2);
		
		M = new int[][] { { 2,3 } };
		expect = new int[][] { { 2,2} };
		output=s.imageSmoother(M);
		Util.verifyUnsort(expect, output,3);
		
		System.out.println("Finish");
	}

}
