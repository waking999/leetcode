package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;

public class Serializeranddeserializer {

    private static Map<Character, Integer> asciiChar;
    private static Map<Integer, Character> asciiDec;

    static {
        asciiChar = new HashMap<>();
        asciiDec = new HashMap<>();

        asciiChar.put('0', 0);
        asciiDec.put(0, '0');

        asciiChar.put('a', 7);
        asciiDec.put(7, 'a');

        asciiChar.put('b', 8);
        asciiDec.put(8, 'b');

        asciiChar.put('t', 9);
        asciiDec.put(9, 't');

        asciiChar.put('n', 10);
        asciiDec.put(10, 'n');

        asciiChar.put('f', 12);
        asciiDec.put(12, 'f');

        asciiChar.put('r', 13);
        asciiDec.put(13, 'r');

    }

    public static String charArrayToString(char[] param) {
        if (param == null) {
            return null;
        }
        int paramLen = param.length;

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < paramLen; i++) {
            sb.append("\"");
            if (param[i] <= (char) 32) {
                //unprintable chars
                sb.append("\\").append(asciiDec.get((int) param[i]));
            } else if ((param[i] == (char) 34) || (param[i] == (char) 92)) {
                //",\,
                sb.append("\\").append(param[i]);
            } else {
                //nornal chars
                sb.append(param[i]);
            }
            sb.append("\"");
            if (i < paramLen - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    // Bonus point if your deserializer is able to deal with whitespaces between
    // elements.
    // For example: param = "[ \"a\", \"b\", \"c\" ]"
    public static char[] stringToCharArray(String param) {
        if (param == null) {
            return null;
        }
        int paramLen = param.length();
        if (paramLen < 2) {
            return null;
        }
        String innerParam = param.substring(1, paramLen - 1);
        int innerParamLen = innerParam.length();
        if (innerParamLen == 0) {
            return new char[]{};
        }
        String[] charArr = innerParam.split("\",");
        int charArrLen = charArr.length;

        char[] chars = new char[charArrLen];
        for (int i = 0; i < charArrLen; i++) {
            String tmpStr = charArr[i].trim();
            char tmpChar = tmpStr.charAt(1);
            if (tmpChar == '\\') {
                if ((tmpStr.charAt(2) >= 'a' && tmpStr.charAt(2) <= 'z') || tmpStr.charAt(2) == '0') {
                    //unprintable chars
                    chars[i] = (char) (asciiChar.get(tmpStr.charAt(2)).intValue());
                } else {
                    //",/
                    chars[i] = tmpStr.charAt(2);
                }
            } else {
                //normal chars
                chars[i] = tmpStr.charAt(1);
            }
        }
        return chars;
    }

    // Note: These tests are basic and passing them does not mean your code is
    // correct.
    // Feel free to write additional tests and test serializer and deserializer
    // individually.


}
