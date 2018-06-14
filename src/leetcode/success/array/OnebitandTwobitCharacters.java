package leetcode.success.array;

public class OnebitandTwobitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null) {
            return false;
        }

        int bitsLen = bits.length;
        if (bitsLen == 0) {
            return false;
        }
        if (bitsLen == 1) {
            return bits[0] == 0;
        }

        int i = 0;
        for (; i < bitsLen - 1; ) {
            if (bits[i] == 1) {
                i = i + 2;
            } else {
                i = i + 1;
            }
        }

        return i < bitsLen;
    }


}
