package history;

import org.junit.Assert;

public class HappyNumberTest {
    public static void main(String[] args) {
        HappyNumber x = new HappyNumber();

        int a;

        a = 19;
        Assert.assertEquals(82, x.digitPower(19));
        Assert.assertTrue(x.isHappy(a));



    }
}
