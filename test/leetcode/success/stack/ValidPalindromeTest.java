package leetcode.success.stack;

import common.Util;
import org.junit.jupiter.api.Test;

public class ValidPalindromeTest {
    @Test
    public void test1() {
        ValidPalindrome s = new ValidPalindrome();

        String str;
        boolean expect;
        boolean output;
        int seq=1;

        str = "A man, a plan, a canal: Panama";
        expect = true;
        output = s.isPalindrome(str);
        Util.verify(expect,output,seq++);

        str = "race a car";
        expect = false;
        output = s.isPalindrome(str);
        Util.verify(expect,output,seq++);

        str = ".,";
        expect = true;
        output = s.isPalindrome(str);
        Util.verify(expect,output,seq++);


        str = "0P";
        expect = false;
        output = s.isPalindrome(str);
        Util.verify(expect,output,seq++);

    }
}
