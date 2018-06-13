package leetcode.pending;

import leetcode.success.comm.Util;

public class RangeAdditionII {
	public int maxCount(int m, int n, int[][] ops) {
		if (ops == null) {
			return m*n;
		}
		int opsRow = ops.length;
		if (opsRow == 0) {
			return m*n;
		}
		int opsCol = ops[0].length;
		if (opsCol == 0) {
			return m*n;
		}
		for (int[] op : ops) {
			//only the minimum range of the operations will be added the most times
			m = Math.min(m, op[0]);
			n = Math.min(n, op[1]);
		}
		return m * n;
	}

	public static void main(String[] args) {
		RangeAdditionII s = new RangeAdditionII();

		int m;
		int n;
		int[][] ops;
		int expect;
		int output;

		m = 3;
		n = 3;
		ops = new int[][] { { 2, 2 }, { 3, 3 } };
		expect = 4;
		output = s.maxCount(m, n, ops);
		Util.verify(expect, output, 1);
		

		m = 3;
		n = 3;
		ops = new int[][] {  };
		expect = 9;
		output = s.maxCount(m, n, ops);
		Util.verify(expect, output, 1);

	}

}
