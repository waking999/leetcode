package lintcode.google.level1;

import leetcode.success.comm.Util;
import org.junit.Test;

/**
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.
 *
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand. For example, "#15c" is shorthand for the color "#1155cc".
 *
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 *
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ")
 *
 * color is a string of length 7.
 * color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
 * Any answer which has the same (highest) similarity as the best answer will be accepted.
 * All inputs and outputs should use lowercase letters, and the output is 7 characters.
 *
 * Example
 * Input: color = "#09f166"
 * Output: "#11ee66"
 * Explanation:
 * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 * This is the highest among any shorthand color.
 */
public class SimilarRGBColor {
    private final static int[] RGB_HEX = {0x0, 0x11, 0x22, 0x33,0x44,0x55,0x66, 0x77, 0x88, 0x99, 0xaa,0xbb,0xcc,0xdd,0xee,0xff};
    private final static String[] RGB_STR={"00", "11", "22", "33","44", "55","66", "77","88", "99","aa", "bb","cc", "dd","ee", "ff"};
    private final static int RGB_LEN =16;
    /*
     *Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ")
     */
    public String similarRGB(String color) {
        long min=Long.MAX_VALUE;
        String rtn=null;
        int r=Integer.parseInt(color.substring(1,3), RGB_LEN);
        int g=Integer.parseInt(color.substring(3,5), RGB_LEN);
        int b=Integer.parseInt(color.substring(5,7), RGB_LEN);
        for(int i = 0; i< RGB_LEN; i++){
            int rDiff=(r- RGB_HEX[i]);
            int r2=rDiff*rDiff;
            for(int j = 0; j< RGB_LEN; j++){
                int gDiff=(g- RGB_HEX[j]);
                int g2=gDiff*gDiff;
                for(int k = 0; k< RGB_LEN; k++){
                    int bDiff=(b- RGB_HEX[k]);
                    int b2=bDiff*bDiff;
                    int diff=r2+g2+b2;
                    if(diff<min){
                        min=diff;
                        rtn="#"+RGB_STR[i]+RGB_STR[j]+RGB_STR[k];
                    }
                }
            }
        }


        return rtn;
    }

    @Test
    public void testsimilarRGB() {
        SimilarRGBColor s=new SimilarRGBColor();

        String color;
        String expect;
        String output;
        int seq=0;

//        color=  "#09f166";
//        expect= "#11ee66";
//        output=s.similarRGB(color);
//        Util.verify(expect,output,seq++);

        color=  "#1c9e03";
        expect= "#229900";
        output=s.similarRGB(color);
        Util.verify(expect,output,seq++);




    }
}
