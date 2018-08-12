package leetcode.success.array;

import common.Util;
import leetcode.success.array.CoinChange;
import org.junit.jupiter.api.Test;

public class CoinChangeTest {
    @Test
    public void test1(){
        CoinChange s=new CoinChange();

        int[] coins;
        int amount;
        int expect;
        int output;
        int seq=1;

        coins=new int[]{1,2,5};
        amount=11;
        expect=3;
        output=s.coinChange(coins,amount);
        Util.verify(expect,output,seq++);

        coins=new int[]{2};
        amount=3;
        expect=-1;
        output=s.coinChange(coins,amount);
        Util.verify(expect,output,seq++);

        coins=new int[]{};
        amount=3;
        expect=-1;
        output=s.coinChange(coins,amount);
        Util.verify(expect,output,seq++);

        coins=new int[]{2};
        amount=1;
        expect=-1;
        output=s.coinChange(coins,amount);
        Util.verify(expect,output,seq++);

        coins=null;
        amount=3;
        expect=-1;
        output=s.coinChange(coins,amount);
        Util.verify(expect,output,seq++);

        coins=new int[]{2,5,10,1};
        amount=27;
        expect=4;
        output=s.coinChange(coins,amount);
        Util.verify(expect,output,seq++);

        coins=new int[]{186,419,83,408};
        amount=6249;
        expect=20;
        output=s.coinChange(coins,amount);
        Util.verify(expect,output,seq++);

     }
}
