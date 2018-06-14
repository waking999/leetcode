package history;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {
    @Test
    public void test1(){
        ReverseString a=new ReverseString();

        String s="hello";
        String expected="olleh";
        String actual=a.reverseString(s);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        ReverseString a=new ReverseString();

        String s="helo";
        String expected="oleh";
        String actual=a.reverseString(s);
        Assert.assertEquals(expected, actual);
    }
}
