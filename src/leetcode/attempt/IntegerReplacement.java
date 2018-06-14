package leetcode.attempt;


import org.junit.Assert;
import org.junit.Test;

public class IntegerReplacement {
    private int integerReplacement(int n) {

        return branch((long)n,0);
    }


    private int branch(long n,int count){
        if(n==1||n==0){
            return 0;
        }
        if(n==2){
            return count+1;
        }
        if(n%2==0){
            return branch(n>>1, count+1);
        }
        return Math.min(branch(n+1,count+1),branch(n-1,count+1));
    }


    @Test
    public void test1() {
        IntegerReplacement x = new IntegerReplacement();

        int n;
        int expect;
        int output;

        n=8;
        expect=3;
        output=x.integerReplacement(n);
        Assert.assertEquals(expect,output);

        n=7;
        expect=4;
        output=x.integerReplacement(n);
        Assert.assertEquals(expect,output);



        n=1;
        expect=0;
        output=x.integerReplacement(n);
        Assert.assertEquals(expect,output);

        n=0;
        expect=0;
        output=x.integerReplacement(n);
        Assert.assertEquals(expect,output);

        n=2;
        expect=1;
        output=x.integerReplacement(n);
        Assert.assertEquals(expect,output);

        n=2147483647;
        expect=32;
        output=x.integerReplacement(n);
        Assert.assertEquals(expect,output);
    }
}
