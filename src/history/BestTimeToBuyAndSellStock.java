package history;
import org.junit.Assert;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int diff = 0;
		
		for(int n:prices){
			min=Math.min(n, min);
			diff=Math.max(diff, n-min);
		}
		
		return diff;
		 

	}



}
