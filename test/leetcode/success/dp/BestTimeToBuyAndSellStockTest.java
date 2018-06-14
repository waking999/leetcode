package leetcode.success.dp;

import common.VerifyUtil;
import history.BestTimeToBuyAndSellStock;
import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void test1() {
        history.BestTimeToBuyAndSellStock x = new BestTimeToBuyAndSellStock();

        int[] arr;
        int expect;
        int output;
        int seq=1;

        arr = new int[] { 7, 1, 5, 3, 6, 4 };
        expect = 5;
        output = x.maxProfit(arr);
        VerifyUtil.verify(expect,output,seq++);

        arr = new int[] { 7, 6, 4, 3, 1 };
        expect = 0;
        output = x.maxProfit(arr);
        VerifyUtil.verify(expect,output,seq++);

        int n = 10000;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        expect = 0;
        output = x.maxProfit(arr);
        VerifyUtil.verify(expect,output,seq++);

    }
}
