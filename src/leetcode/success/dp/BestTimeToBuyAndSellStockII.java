package leetcode.success.dp;

 

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		if(prices.length<2){
			return 0;
		}
		int sum=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>prices[i-1]){
				sum+=(prices[i]-prices[i-1]);
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII s = new BestTimeToBuyAndSellStockII();

		int[] input;
		int expect;
		int output;

		input = new int[] { 7, 1, 5, 3, 6, 4 };
		expect = 7;
		output = s.maxProfit(input);
		assert (expect == output) : "1 wrong";

		input = new int[] { 7, 6, 4, 3, 1 };
		expect = 0;
		output = s.maxProfit(input);
		assert (expect == output) : "2 wrong";

		input = new int[] {  };
		expect = 0;
		output = s.maxProfit(input);
		assert (expect == output) : "3 wrong";

		input = new int[] {  1};
		expect = 0;
		output = s.maxProfit(input);
		assert (expect == output) : "4 wrong";
		
		System.out.println("Finish");

	}

}
