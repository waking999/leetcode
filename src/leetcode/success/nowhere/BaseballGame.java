package leetcode.success.nowhere;

import java.util.Stack;

import leetcode.success.comm.Util;

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

		for (int i = 0; i < opsLen; i++) {
			String s = ops[i];

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

	public static void main(String[] args) {
		BaseballGame s = new BaseballGame();

		String[] ops;
		int expect;
		int output;
		int seq = 0;

		ops = new String[] { "5", "2", "C", "D", "+" };
		expect = 30;
		output = s.calPoints(ops);
		Util.verifyUnsort(expect, output, ++seq);

		ops = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };
		expect = 27;
		output = s.calPoints(ops);
		Util.verifyUnsort(expect, output, ++seq);

		ops = new String[] { "8373", "C", "9034", "-17523", "D", "1492", "7558", "-5022", "C", "C", "+", "+", "-16000",
				"C", "+", "-18694", "C", "C", "C", "-19377", "D", "-25250", "20356", "C", "-1769", "-8303", "C",
				"-25332", "29884", "C", "+", "C", "-29875", "-15374", "C", "+", "14584", "13773", "+", "17037",
				"-28248", "+", "16822", "D", "+", "+", "-19357", "-26593", "-8548", "4776", "D", "-8244", "378", "+",
				"-19269", "-25447", "18922", "-16782", "2886", "C", "-17788", "D", "-22256", "C", "308", "-9185",
				"-19074", "1528", "28424", "D", "8658", "C", "7221", "-13704", "8995", "-21650", "22567", "-29560", "D",
				"-9807", "25632", "6817", "28654", "D", "-18574", "C", "D", "20103", "7875", "C", "9911", "23951", "C",
				"D", "C", "+", "18219", "-20922", "D", "-24923" };
		expect = -16293;
		output = s.calPoints(ops);
		Util.verifyUnsort(expect, output, ++seq);

	}

}
