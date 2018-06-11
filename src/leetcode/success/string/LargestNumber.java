package leetcode.success.string;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.Collections;
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

        List<NumStr> strs = IntStream.of(nums).boxed().map(e -> new NumStr(e.toString())).collect(Collectors.toList());

        Collections.sort(strs);

        if ("0".equals(strs.get(numsLen - 1).val)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = numsLen - 1; i >= 0; i--) {
            sb.append(strs.get(i).val);
        }


        String str = sb.toString();

        return str;
    }

    @Test
    public void testlargestNumber() {
        LargestNumber s = new LargestNumber();

        int[] nums;
        String expect;
        String output;
        int seq = 0;


        nums = new int[]{10, 2};
        expect = "210";
        output = s.largestNumber(nums);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{3, 30, 34, 5, 9};
        expect = "9534330";
        output = s.largestNumber(nums);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{12, 121};
        expect = "12121";
        output = s.largestNumber(nums);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{121, 12};
        expect = "12121";
        output = s.largestNumber(nums);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{0, 0};
        expect = "0";
        output = s.largestNumber(nums);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{9051,5526,2264,5041,1630,5906,6787,8382,4662,4532,6804,4710,4542,2116,7219,8701,8308,957,8775,4822,396,8995,8597,2304,8902,830,8591,5828,9642,7100,3976,5565,5490,1613,5731,8052,8985,2623,6325,3723,5224,8274,4787,6310,3393,78,3288,7584,7440,5752,351,4555,7265,9959,3866,9854,2709,5817,7272,43,1014,7527,3946,4289,1272,5213,710,1603,2436,8823,5228,2581,771,3700,2109,5638,3402,3910,871,5441,6861,9556,1089,4088,2788,9632,6822,6145,5137,236,683,2869,9525,8161,8374,2439,6028,7813,6406,7519};
        expect = "995998549642963295795569525905189958985890288238775871870185978591838283748308830827481618052787813771758475277519744072727265721971071006861683682268046787640663256310614560285906582858175752573156385565552654905441522852245213513750414822478747104662455545424532434289408839763963946391038663723370035134023393328828692788270926232581243924362362304226421162109163016131603127210891014";
        output = s.largestNumber(nums);
        Util.verifyUnsort(expect, output, seq++);

    }


    @Test
    public void testcompare(){
        String a="8308";
        String b="830";

        boolean output=new NumStr(a).compareTo(new NumStr(b))>0;
        boolean expect=true;

        Util.verifyUnsort(expect,output,0);

    }
}


class NumStr implements Comparable<NumStr> {
    String val;

    NumStr(String val) {
        this.val = val;
    }


    @Override
    public int compareTo(NumStr o) {
        if (o == null) {
            return 1;
        }

        if ("".equals(o)) {
            return 1;
        }
        if (val.equals(o)) {
            return 0;
        }
        String oVal = ((NumStr) o).val;
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