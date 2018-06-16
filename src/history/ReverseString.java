package history;

public class ReverseString {
    public String reverseString(String s) {
        byte[] bytes = s.getBytes();
        int sLen = s.length();
        int half = 0;
        if (sLen % 2 == 0) {
            half = sLen / 2;
        } else {
            half = (sLen - 1) / 2;
        }

        for (int i = 0; i < half; i++) {
            byte tmp = bytes[i];
            int j = sLen - 1 - i;
            bytes[i] = bytes[j];
            bytes[j] = tmp;
        }

        return new String(bytes);
    }


}
