package leetcode.success.other;

import java.util.Stack;

public class BaseballGame {
	public int calPoints(String[] ops) {
		if (ops == null) {
			return 0;
		}
		int opsLen = ops.length;
		if (opsLen == 0) {
			return 0;
		}
		Stack<Integer> lastValids = new Stack<>();

		int sum = 0;

		for (String s : ops) {
			if ("C".equals(s)) {
				sum -= lastValids.pop();
			} else if ("D".equals(s)) {
				int tmp = lastValids.peek();
				lastValids.push(2 * tmp);
				sum += lastValids.peek();
			} else if ("+".equals(s)) {
				int tmp1 = lastValids.pop();
				int tmp2 = lastValids.peek();
				int tmp = tmp1 + tmp2;
				sum += tmp;
				lastValids.push(tmp1);
				lastValids.push(tmp);
			} else {
				int curr = Integer.parseInt(s);
				sum += curr;
				lastValids.push(curr);
			}

		}
		return sum;
	}



}
