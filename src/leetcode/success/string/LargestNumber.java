package leetcode.success.string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null) {
            return null;
        }
        int numsLen = nums.length;
        if (numsLen == 0) {
            return null;
        }
        if (numsLen == 1) {
            return Integer.toString(nums[0]);
        }

        List<NumStr> strs = IntStream.of(nums).boxed().map(e -> new NumStr(e.toString())).sorted().collect(Collectors.toList());

        if ("0".equals(strs.get(numsLen - 1).getVal())) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = numsLen - 1; i >= 0; i--) {
            sb.append(strs.get(i).getVal());
        }


        return sb.toString();
    }


}


class NumStr implements Comparable<NumStr> {
    private String val;

    NumStr(String val) {
        this.val = val;
    }

    String getVal(){
        return this.val;
    }

    @Override
    public int compareTo(NumStr o) {
        if (o == null) {
            return 1;
        }

        if ("".equals(o.val)) {
            return 1;
        }
        if (val.equals(o.val)) {
            return 0;
        }
        String oVal = o.val;
        return compare(val, oVal);


    }


    private int compare(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if (aLen == 1 && bLen >= 1) {

            for (int i = 0; i < bLen; i++) {
                if (a.charAt(0) != b.charAt(i)) {
                    return a.charAt(0) - b.charAt(i);
                }
            }
            return 0;
        }

        if (bLen == 1 && aLen >= 1) {

            for (int i = 0; i < aLen; i++) {
                if (a.charAt(i) != b.charAt(0)) {
                    return a.charAt(i) - b.charAt(0);
                }
            }
            return 0;
        }


        if (aLen == bLen) {
            return a.compareTo(b);
        } else if (aLen < bLen) {
            String newB = b.substring(0, aLen);
            if (a.equals(newB)) {
                return compare(a, b.substring(aLen));
            } else {
                return a.compareTo(newB);
            }

        } else {
            String newA = a.substring(0, bLen);
            if (newA.equals(b)) {
                return compare(a.substring(bLen), b);
            } else {
                return newA.compareTo(b);
            }
        }

    }


}