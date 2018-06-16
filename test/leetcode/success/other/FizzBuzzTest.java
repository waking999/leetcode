package leetcode.success.other;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class FizzBuzzTest {
    @Test
    public void test1() {
        FizzBuzz s = new FizzBuzz();

        int n;
        String[] expect;
        List<String> output;


        n = 15;
        expect = new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
                "14", "FizzBuzz"};
        output = s.fizzBuzz(n);
        verifyUnsort(expect, output, 1);

        System.out.println("Finish");
    }
}
