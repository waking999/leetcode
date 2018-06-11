package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;

import static leetcode.success.comm.Util.verifyUnsort;

public class Serializeranddeserializer {

	static Map<Character, Integer> asciiChar;
	static Map<Integer, Character> asciiDec;

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
			return new char[] {};
		}
		String[] charArr = innerParam.split("\",");
		int charArrLen = charArr.length;

		char[] chars = new char[charArrLen];
		for (int i = 0; i < charArrLen; i++) {
			String tmpStr=charArr[i].trim();
			char tmpChar = tmpStr.charAt(1);
			if (tmpChar == '\\') {
				if ((tmpStr.charAt(2) >= 'a' && tmpStr.charAt(2) <= 'z') ||tmpStr.charAt(2) == '0'){
					//unprintable chars
					chars[i] = (char) (asciiChar.get(tmpStr.charAt(2)).intValue());
				} else {
					//",/
					chars[i] = tmpStr.charAt(2);
				}
			} else {
				//normal chars
				chars[i] =tmpStr.charAt(1);
			}
		}
		return chars;
	}

	// Note: These tests are basic and passing them does not mean your code is
	// correct.
	// Feel free to write additional tests and test serializer and deserializer
	// individually.
	public static void main(String[] args) {

		String param = null;
		char[] output = null;
		char[] expect = null;
		int seq = 0;

		param = "[]";
		expect = new char[] {};
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);

		param = "[\"a\",\"b\",\"c\"]";
		expect = new char[] { 'a', 'b', 'c' };
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);
		
		
		param = "[\"a\", \"b\", \"c\"]";
		expect = new char[] { 'a', 'b', 'c' };
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);
		
		param = "[\"a\", \"b\",\"c\"]";
		expect = new char[] { 'a', 'b', 'c' };
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);

		param = "[\"T\",\"e\",\"!\",\"'\"]";
		expect = new char[] { 'T', 'e', '!', '\'' };
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);

		param = "[\"'\",\"\\\"\",\"c\"]";
		expect = new char[] { '\'', '\"', 'c' };
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);

		param = "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]";
		expect = new char[] { '\n', '\t', '\'', '\"', '\\' };
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);
		
		
		param = "[\"\\0\",\"\\f\",\"\\b\",\"\\r\",\"0\",\"A\"]";
		expect = new char[]  { '\0', '\f', '\b', '\r','0','A'};
		try {
			output = stringToCharArray(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expect, output, seq++);
		

		char[] paramChar = null;
		String expectStr = null;
		String outputStr = null;

		paramChar = new char[] {};
		expectStr = "[]";
		try {
			outputStr = charArrayToString(paramChar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expectStr, outputStr, seq++);

		paramChar = new char[] { 'a', 'b', 'c' };
		expectStr = "[\"a\",\"b\",\"c\"]";
		try {
			outputStr = charArrayToString(paramChar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expectStr, outputStr, seq++);

		paramChar = new char[] { 'T', 'e', '!', '\'' };
		expectStr = "[\"T\",\"e\",\"!\",\"'\"]";
		try {
			outputStr = charArrayToString(paramChar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expectStr, outputStr, seq++);

		paramChar = new char[] { '\'', '\"', 'c' };
		expectStr = "[\"'\",\"\\\"\",\"c\"]";
		try {
			outputStr = charArrayToString(paramChar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expectStr, outputStr, seq++);

		paramChar = new char[] { '\n', '\t', '\'', '\"', '\\' };
		expectStr = "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]";
		try {
			outputStr = charArrayToString(paramChar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expectStr, outputStr, seq++);
		
		
		paramChar = new char[] { '\0', '\f', '\b', '\r','0','A'};
		expectStr = "[\"\\0\",\"\\f\",\"\\b\",\"\\r\",\"0\",\"A\"]";
		try {
			outputStr = charArrayToString(paramChar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		verifyUnsort(expectStr, outputStr, seq++);

		String[] testcases = { "[]", "[\"a\",\"b\",\"c\"]", "[\"T\",\"e\",\"!\",\"'\"]", "[\"'\",\"\\\"\",\"c\"]",
				"[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]","[\"\\0\",\"\\f\",\"\\b\",\"\\r\",\"0\",\"A\"]" };

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
