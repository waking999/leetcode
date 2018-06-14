package leetcode.success.string;

public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		char[] steps = moves.toCharArray();
		for (char c : steps) {
			switch (c) {
			case 'U': {
				y++;
				break;
			}
			case 'D': {
				y--;
				break;
			}
			case 'R': {
				x++;
				break;
			}
			case 'L': {
				x--;
				break;
			}
			}
		}
		return (x == 0 && y == 0);
	}

	public static void main(String[] args) {
		JudgeRouteCircle s = new JudgeRouteCircle();

		String input = "UD";
		boolean expect = true;

		boolean output = s.judgeCircle(input);
		assert (expect == output) : "1.Result not right.";


		input = "LL";
		expect = false;

		output = s.judgeCircle(input);
		assert (expect == output) : "2.Result not right.";

		System.out.println("Finished");
	}

}
