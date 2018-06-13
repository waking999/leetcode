package leetcode.success.array;


import leetcode.success.comm.Util;
import org.junit.Test;


public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();

        if (num1Len == 1) {
            if (num1.charAt(0) == '0') {
                return "0";
            }
            if (num1.charAt(0) == '1') {
                return num2;
            }
        }

        if (num2Len == 1) {
            if (num2.charAt(0) == '0') {
                return "0";
            }
            if (num2.charAt(0) == '1') {
                return num1;
            }
        }

        int totalLen = num1Len + num2Len;
        int[] result = new int[totalLen];
        for (int i = num2Len - 1; i >= 0; i--) {
            int b = num2.charAt(i) - '0';

            for (int j = num1Len - 1; j >= 0; j--) {
                int a = num1.charAt(j) - '0';
                result[totalLen - 2 - i - j] += a * b;
            }
        }

        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for (int i = 0; i < totalLen - 1; i++) {
            int sum = result[i] + carrier;
            carrier = sum / 10;

            sb.append(sum % 10);
        }
        if (carrier > 0) {
            sb.append(carrier);
        }

        return sb.reverse().toString();


    }

    @Test
    void testmultiply() {
        MultiplyStrings s = new MultiplyStrings();
        String num1;
        String num2;
        String expect;
        String output;
        int seq = 0;


        num1 = "2";
        num2 = "3";
        expect = "6";
        output = s.multiply(num1, num2);
        Util.verify(expect, output, seq++);

        num1 = "123";
        num2 = "456";
        expect = "56088";
        output = s.multiply(num1, num2);
        Util.verify(expect, output, seq++);

        num1 = "9";
        num2 = "9";
        expect = "81";
        output = s.multiply(num1, num2);
        Util.verify(expect, output, seq++);

        num1 = "999";
        num2 = "999";
        expect = "998001";
        output = s.multiply(num1, num2);
        Util.verify(expect, output, seq++);

        num1 = "9133";
        num2 = "0";
        expect = "0";
        output = s.multiply(num1, num2);
        Util.verify(expect, output, seq++);

    }
}
