package leetcode.success.recursion;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffersTest {
    @Test
    public void test1() {
        ShoppingOffers s = new ShoppingOffers();


        Integer[] priceArray;
        List<Integer> price;
        Integer[][] specialArray;
        List<List<Integer>> special;
        Integer[] needsArray;
        List<Integer> needs;
        int expect;
        int output;
        int seq = 1;

        priceArray = new Integer[]{2, 5};
        specialArray = new Integer[][]{{3, 0, 5}, {1, 2, 10}};
        needsArray = new Integer[]{3, 2};
        price = Arrays.asList(priceArray);
        special = new ArrayList<>();
        for (Integer[] a : specialArray) {
            special.add(Arrays.asList(a));
        }
        needs = Arrays.asList(needsArray);
        expect = 14;
        output = s.shoppingOffers(price, special, needs);
        Util.verify(expect, output, seq++);


        priceArray = new Integer[]{2, 3, 4};
        specialArray = new Integer[][]{{1, 1, 0, 4}, {2, 2, 1, 9}};
        needsArray = new Integer[]{1, 2, 1};
        price = Arrays.asList(priceArray);
        special = new ArrayList<>();
        for (Integer[] a : specialArray) {
            special.add(Arrays.asList(a));
        }
        needs = Arrays.asList(needsArray);
        expect = 11;
        output = s.shoppingOffers(price, special, needs);
        Util.verify(expect, output, seq++);


        priceArray = new Integer[]{2, 3, 4};
        specialArray = new Integer[][]{{1, 1, 0, 4}, {2, 2, 1, 9}, {1, 2, 0, 5}};
        needsArray = new Integer[]{1, 2, 1};
        price = Arrays.asList(priceArray);
        special = new ArrayList<>();
        for (Integer[] a : specialArray) {
            special.add(Arrays.asList(a));
        }
        needs = Arrays.asList(needsArray);
        expect = 9;
        output = s.shoppingOffers(price, special, needs);
        Util.verify(expect, output, seq++);



        priceArray = new Integer[]{0,0,0};
        specialArray = new Integer[][]{{1,1,0,4}, {2, 2, 1, 9}};
        needsArray = new Integer[]{2, 2, 1};
        price = Arrays.asList(priceArray);
        special = new ArrayList<>();
        for (Integer[] a : specialArray) {
            special.add(Arrays.asList(a));
        }
        needs = Arrays.asList(needsArray);
        expect = 0;
        output = s.shoppingOffers(price, special, needs);
        Util.verify(expect, output, seq++);



        
        priceArray = new Integer[]{2,3};
        specialArray = new Integer[][]{{1,0,1},{0,1,2}};
        needsArray = new Integer[]{1,1};
        price = Arrays.asList(priceArray);
        special = new ArrayList<>();
        for (Integer[] a : specialArray) {
            special.add(Arrays.asList(a));
        }
        needs = Arrays.asList(needsArray);
        expect = 3;
        output = s.shoppingOffers(price, special, needs);
        Util.verify(expect, output, seq++);
    }
}
