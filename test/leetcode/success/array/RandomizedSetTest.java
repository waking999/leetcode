package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomizedSetTest {
    @Test
    public void test1() {
        int seq=1;
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        Util.verify(true,randomSet.insert(1),seq++);

// Returns false as 2 does not exist in the set.
        Util.verify(false, randomSet.remove(2),seq++);

// Inserts 2 to the set, returns true. Set now contains [1,2].
        Util.verify(true,randomSet.insert(2),seq++);

// getRandom should return either 1 or 2 randomly.
        int output=randomSet.getRandom();
        if(output==1||output==2){

        }else{
            Assertions.assertTrue(false,seq+" wrong.");
        }
        seq++;

// Removes 1 from the set, returns true. Set now contains [2].
        Util.verify(true,randomSet.remove(1),seq++);

// 2 was already in the set, so return false.
        Util.verify(false,randomSet.insert(2),seq++);

// Since 2 is the only number in the set, getRandom always return 2.
        output=randomSet.getRandom();
        if(output==2){

        }else{
            Assertions.assertTrue(false,seq+" wrong.");
        }
        seq++;
    }

    @Test
    public void test2() {
        int seq=1;

        RandomizedSet randomSet = new RandomizedSet();


        Util.verify(true,randomSet.insert(0),seq++);
        Util.verify(true,randomSet.insert(1),seq++);
        Util.verify(true, randomSet.remove(0),seq++);
        Util.verify(true,randomSet.insert(2),seq++);
        Util.verify(true, randomSet.remove(1),seq++);

        int output=randomSet.getRandom();
        if( output==2){

        }else{
            Assertions.assertTrue(false,seq+" wrong.");
        }
        seq++;

    }

    @Test
    public void test3() {
        int seq=1;

        RandomizedSet randomSet = new RandomizedSet();
        Util.verify(false,randomSet.remove(0),seq++);
        Util.verify(false,randomSet.remove(0),seq++);
        Util.verify(true,randomSet.insert(0),seq++);

        int output=randomSet.getRandom();
        if( output==0){

        }else{
            Assertions.assertTrue(false,seq+" wrong.");
        }
        seq++;

        Util.verify(true,randomSet.remove(0),seq++);
        Util.verify(true,randomSet.insert(0),seq++);
    }
}
