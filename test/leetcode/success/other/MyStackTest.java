package leetcode.success.other;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class MyStackTest {
    @Test
    public void test1() {
        MyStack obj = new MyStack();
        int x = 4;
        obj.push(x);

        int param3 = obj.top();
        verify(x, param3, 1);

        boolean param4 = obj.empty();
        verify(false, param4, 2);

        int param5 = obj.pop();
        verify(x, param5, 3);

        param4 = obj.empty();
        verify(true, param4, 4);
    }
}
