package leetcode.success.array;

import org.junit.Test;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row=matrix.length;
		if(row==0){
			return false;
		}
		int col=matrix[0].length;
		if(col==0){
			return false;
		}
		if(target<matrix[0][0]){
			return false;
		}
		if(target>matrix[row-1][col-1]){
			return false;
		}
		int rowNum=0;
		int colNum=col-1;
		while(rowNum<row&&colNum>=0){
			if(target<matrix[rowNum][colNum]){
				colNum--;
			}else if(target>matrix[rowNum][colNum]){
				rowNum++;
			}else{
				return true;
			}
		}
		
		
		return false;
	}

	@Test
	public void test1() {
		SearchA2DMatrix s = new SearchA2DMatrix();

		int[][] matrix;
		int target;
		boolean expect;
		boolean output;

		matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		target = 3;
		expect = true;
		output = s.searchMatrix(matrix, target);
		assert (expect == output) : "1:wrong";

		System.out.println("Finish");

	}

}
