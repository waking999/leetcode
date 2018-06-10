package leetcode.pending;

public class TotalHammingDistance {

	public int totalHammingDistance(int[] nums) {
		int total = 0;
		int n = nums.length;
		for (int i = 0; i < 9; i++) {
			int counter = 0;
			for (int j = 0; j < n; j++) {
				counter += (nums[j] >> i) & 0x01;
			}
			total += counter * (n - counter);
		}
		return total;
	}

	public static void main(String[] args) {
		TotalHammingDistance s = new TotalHammingDistance();

		int[] input = { 4, 14, 2 };
		int expect = 6;

		int output = s.totalHammingDistance(input);
		assert (expect == output) : "1.Result is not right.";

		input = new int[] {1337,7331};
		expect = 7;
		output = s.totalHammingDistance(input);
		assert (expect == output) : "2.Result is not right.";
		System.out.println("Finished");

	}

}
