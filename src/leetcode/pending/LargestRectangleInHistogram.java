package leetcode.pending;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
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
		LargestRectangleInHistogram s = new LargestRectangleInHistogram();

		int[] heights;
		int expect;
		int output;

		heights = new int[] { 2, 1, 5, 6, 2, 3 };
		expect = 10;
		output = s.largestRectangleArea(heights);
		assert (expect == output) : "1:wrong";

		heights = new int[] { 0, 0, 0 };
		expect = 0;
		output = s.largestRectangleArea(heights);
		assert (expect == output) : "2:wrong";

		heights = new int[] { 2, 1, 0, 2 };
		expect = 2;
		output = s.largestRectangleArea(heights);
		assert (expect == output) : "3:wrong";

		heights = new int[] { 0,9 };
		expect = 9;
		output = s.largestRectangleArea(heights);
		assert (expect == output) : "4:wrong";
		
		System.out.println("Finish");

	}

}
