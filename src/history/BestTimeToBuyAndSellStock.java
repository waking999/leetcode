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

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock x = new BestTimeToBuyAndSellStock();

		int[] arr;
		int e;
		int a;
		arr = new int[] { 7, 1, 5, 3, 6, 4 };
		e = 5;
		a = x.maxProfit(arr);
		Assert.assertEquals(e, a);

		arr = new int[] { 7, 6, 4, 3, 1 };
		e = 0;
		a = x.maxProfit(arr);
		Assert.assertEquals(e, a);

		int n = 10000;
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = n - i;
		}
		e = 0;
		a = x.maxProfit(arr);
		Assert.assertEquals(e, a);

		System.out.println("done");

	}

}
