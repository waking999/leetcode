package leetcode.success.array;


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


}
