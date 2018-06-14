package leetcode.success.bit;


public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; num != 0 && i < 8; i++) {
            int t = num & 0xf;
            if (t >= 10) {
                sb.insert(0, (char) ('a' + t - 10));
            } else {
                sb.insert(0, (char) ('0' + t));
            }
            num >>= 4;
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }


}
