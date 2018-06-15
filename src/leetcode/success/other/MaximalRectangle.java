package leetcode.success.other;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		
		int row=matrix.length;
		if(row==0){
			return 0;
		}
		
		int col=matrix[0].length;
		if(col==0){
			return 0;
		}
		
		int[][] heights=new int[row][col];
		for(int i=0;i<row;i++){			
			for(int j=0;j<col;j++){
				if(matrix[i][j]=='0'){
					heights[i][j]=0;
				}else{
					heights[i][j]=(i==0)?1:heights[i-1][j]+1;
				}
			}			
		}
		
		int sum=0;
		for(int i=0;i<row;i++){
			sum=Math.max(sum, largestRectangleArea(heights[i]));
		}
		
		return sum;
	}
	private int largestRectangleArea(int[] heights) {
		int n = heights.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return heights[0];
		}
		heights=Arrays.copyOf(heights, n+1);
		heights[n]=0;
		
		int sum = 0;
		int i=0;
		Stack<Integer> s=new Stack<>();
		while(i<n+1){
			if(s.isEmpty()||heights[i]>heights[s.peek()]){
				s.push(i);
				i++;
			}else{
				int t=s.peek();
				s.pop();
				sum=Math.max(sum,heights[t]*(s.isEmpty()?i:i-s.peek()-1));
			}
		}
		 

		return sum;

	}
	public static void main(String[] args) {
		MaximalRectangle s = new MaximalRectangle();

		char[][] matrix;
		int expect;
		int output;

		matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		expect = 6;
		output = s.maximalRectangle(matrix);
		assert (expect == output) : "1:wrong";

		System.out.println("Finish");

	}

}
