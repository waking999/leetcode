package leetcode.success.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		Integer[] row=new Integer[rowIndex+1];
		Arrays.fill(row, 1);		
		List<Integer> rowList=Arrays.asList(row);
		for(int i=0;i<=rowIndex;i++){
			for(int j=i-1;j>=1;j--){
				rowList.set(j, rowList.get(j)+rowList.get(j-1));
			}
		}
		return rowList;
	}

	@Test
	public void test1() {
		PascalsTriangleII s = new PascalsTriangleII();

		int rowIndex = 0;
		Integer[] row = new Integer[] { 1 };
		List<Integer> expect = Arrays.asList(row);
		List<Integer> output = s.getRow(rowIndex);
		int outputLen = output.size();
		int expectLen = expect.size();
		assert (outputLen == expectLen) : "0.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (output.get(i).equals(expect.get(i))) : "0.wrong";
		}

		rowIndex = 1;
		row = new Integer[] { 1, 1 };
		expect = Arrays.asList(row);
		output = s.getRow(rowIndex);
		outputLen = output.size();
		expectLen = expect.size();
		assert (outputLen == expectLen) : "1.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (output.get(i).equals(expect.get(i))) : "1.wrong";
		}

		rowIndex = 2;
		row = new Integer[] { 1, 2, 1 };
		expect = Arrays.asList(row);
		output = s.getRow(rowIndex);
		outputLen = output.size();
		expectLen = expect.size();
		assert (outputLen == expectLen) : "2.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (output.get(i).equals(expect.get(i))) : "2.wrong";
		}

		rowIndex = 3;
		row = new Integer[] { 1, 3, 3, 1 };
		expect = Arrays.asList(row);
		output = s.getRow(rowIndex);
		outputLen = output.size();
		expectLen = expect.size();
		assert (outputLen == expectLen) : "3.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (output.get(i).equals(expect.get(i))) : "3.wrong";
		}

		rowIndex = 4;
		row = new Integer[] { 1, 4, 6, 4, 1 };
		expect = Arrays.asList(row);
		output = s.getRow(rowIndex);
		outputLen = output.size();
		expectLen = expect.size();
		assert (outputLen == expectLen) : "4.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (output.get(i).equals(expect.get(i))) : "4.wrong";
		}

		System.out.println("Finish");

	}

}
