package leetcode.success.dp;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if(prices.length<2){
			return 0;
		}
		int minPrice=prices[0];
		int maxProfit=prices[1]-prices[0];
		
		for(int i=2;i<prices.length;i++){
			minPrice=Math.min(prices[i-1], minPrice);
			maxProfit=Math.max(maxProfit, prices[i]-minPrice);
		}
		maxProfit=maxProfit<=0?0:maxProfit;
		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();

		int[] input;
		int expect;
		int output;

		input = new int[] { 7, 1, 5, 3, 6, 4 };
		expect = 5;
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
