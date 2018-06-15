package leetcode.pending;

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



}
