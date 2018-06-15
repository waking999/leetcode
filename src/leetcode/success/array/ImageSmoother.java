package leetcode.success.array;

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



}
