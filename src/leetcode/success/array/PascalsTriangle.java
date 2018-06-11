package leetcode.success.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result=new ArrayList<List<Integer>>(numRows);
		for(int i=0;i<numRows;i++){
			List<Integer> row=new ArrayList<Integer>(i+1);
			result.add(row);
			row.add(1);
			if(i==0){
				continue;
			}
			List<Integer> lastRow=result.get(i-1);
			
			for(int j=1;j<=i-1;j++){
				row.add(j, lastRow.get(j-1)+lastRow.get(j));
			}
			row.add(1);
		}
		
		
		return result;
	}

	@Test
	public void test1() {
		PascalsTriangle s = new PascalsTriangle();

		int numRows = 5;
		List<List<Integer>> expect = new ArrayList<List<Integer>>();
		Integer[] row = new Integer[] { 1 };
		List<Integer> rowList = Arrays.asList(row);
		expect.add(rowList);
		row = new Integer[] { 1, 1 };
		rowList = Arrays.asList(row);
		expect.add(rowList);
		row = new Integer[] { 1, 2, 1 };
		rowList = Arrays.asList(row);
		expect.add(rowList);
		row = new Integer[] { 1, 3, 3, 1 };
		rowList = Arrays.asList(row);
		expect.add(rowList);
		row = new Integer[] { 1, 4, 6, 4, 1 };
		rowList = Arrays.asList(row);
		expect.add(rowList);
		List<List<Integer>> output = s.generate(numRows);
		int outputLen = output.size();
		int expectLen = expect.size();
		assert (outputLen == expectLen) : "1.wrong";
		for (int i = 0; i < numRows; i++) {
			List<Integer> outputRow = output.get(i);
			List<Integer> expectRow = expect.get(i);
			int outputRowLen = outputRow.size();
			int expectRowLen = expectRow.size();
			assert (outputRowLen == expectRowLen) : "1.wrong";
			for (int j = 0; j < expectRowLen; j++) {
				assert (outputRow.get(j) == expectRow.get(j)) : "1.wrong";
			}
		}

		System.out.println("Finish");

	}

}
