package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;
import static common.Util.verifyUnsort;
import static leetcode.success.array.Serializeranddeserializer.charArrayToString;
import static leetcode.success.array.Serializeranddeserializer.stringToCharArray;

public class SerializeranddeserializerTest {
    @Test
    public void test1() {


        String param = null;
        char[] output = null;
        char[] expect = null;
        int seq = 0;

        param = "[]";
        expect = new char[]{};

        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);

        param = "[\"a\",\"b\",\"c\"]";
        expect = new char[]{'a', 'b', 'c'};
        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);


        param = "[\"a\", \"b\", \"c\"]";
        expect = new char[]{'a', 'b', 'c'};
        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);

        param = "[\"a\", \"b\",\"c\"]";
        expect = new char[]{'a', 'b', 'c'};
        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);

        param = "[\"T\",\"e\",\"!\",\"'\"]";
        expect = new char[]{'T', 'e', '!', '\''};
        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);

        param = "[\"'\",\"\\\"\",\"c\"]";
        expect = new char[]{'\'', '\"', 'c'};
        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);

        param = "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]";
        expect = new char[]{'\n', '\t', '\'', '\"', '\\'};
        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);

        param = "[\"\\0\",\"\\f\",\"\\b\",\"\\r\",\"0\",\"A\"]";
        expect = new char[]{'\0', '\f', '\b', '\r', '0', 'A'};
        output = stringToCharArray(param);
        verifyUnsort(expect, output, seq++);


        char[] paramChar = null;
        String expectStr = null;
        String outputStr = null;

        paramChar = new char[]{};
        expectStr = "[]";
        outputStr = charArrayToString(paramChar);
        verify(expectStr, outputStr, seq++);

        paramChar = new char[]{'a', 'b', 'c'};
        expectStr = "[\"a\",\"b\",\"c\"]";
        outputStr = charArrayToString(paramChar);
        verify(expectStr, outputStr, seq++);

        paramChar = new char[]{'T', 'e', '!', '\''};
        expectStr = "[\"T\",\"e\",\"!\",\"'\"]";
        outputStr = charArrayToString(paramChar);
        verify(expectStr, outputStr, seq++);

        paramChar = new char[]{'\'', '\"', 'c'};
        expectStr = "[\"'\",\"\\\"\",\"c\"]";
        outputStr = charArrayToString(paramChar);
        verify(expectStr, outputStr, seq++);

        paramChar = new char[]{'\n', '\t', '\'', '\"', '\\'};
        expectStr = "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]";
        outputStr = charArrayToString(paramChar);
        verify(expectStr, outputStr, seq++);


        paramChar = new char[]{'\0', '\f', '\b', '\r', '0', 'A'};
        expectStr = "[\"\\0\",\"\\f\",\"\\b\",\"\\r\",\"0\",\"A\"]";
        outputStr = charArrayToString(paramChar);
        verify(expectStr, outputStr, seq++);

        String[] testcases = {"[]", "[\"a\",\"b\",\"c\"]", "[\"T\",\"e\",\"!\",\"'\"]", "[\"'\",\"\\\"\",\"c\"]",
                "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]", "[\"\\0\",\"\\f\",\"\\b\",\"\\r\",\"0\",\"A\"]"};

        for (String testcase : testcases) {

            try {

                if (!charArrayToString(stringToCharArray(testcase)).equals(testcase)) {
                    System.out.println("TESTCASE FAILED : {}" + testcase);
                } else {
                    System.out.println("TESTCASE PASSED");
                }
            } catch (Exception e) {
                System.out.println("Exception occured in testcase : " + testcase);
                break;
            }

        }

    }
}
