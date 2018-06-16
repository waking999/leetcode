package leetcode.success.string;

import static common.Util.verify;

public class AddBinaryTest {
    public static void main(String[] args) {
        AddBinary s = new AddBinary();

        String a;
        String b;
        String expect;
        String output;

        a = "11";
        b = "1";
        expect = "100";
        output = s.addBinary(a, b);
        verify(expect, output, 1);


        a = "11";
        b = "11";
        expect = "110";
        output = s.addBinary(a, b);
        verify(expect, output, 2);

        a = "11";
        b = "111";
        expect = "1010";
        output = s.addBinary(a, b);
        verify(expect, output, 3);

        a = "10";
        b = "1";
        expect = "11";
        output = s.addBinary(a, b);
        verify(expect, output, 4);

        a = "1";
        b = "10";
        expect = "11";
        output = s.addBinary(a, b);
        verify(expect, output, 5);

        a = "";
        b = "1";
        expect = "1";
        output = s.addBinary(a, b);
        verify(expect, output, 6);

        a = "1";
        b = "";
        expect = "1";
        output = s.addBinary(a, b);
        verify(expect, output, 7);

        a = "100";
        b = "1";
        expect = "101";
        output = s.addBinary(a, b);
        verify(expect, output, 8);

        a = "1";
        b = "100";
        expect = "101";
        output = s.addBinary(a, b);
        verify(expect, output, 9);

        a = "100";
        b = "10";
        expect = "110";
        output = s.addBinary(a, b);
        verify(expect, output, 10);


    }
}
