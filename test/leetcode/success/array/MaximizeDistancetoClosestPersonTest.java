package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class MaximizeDistancetoClosestPersonTest {
    @Test
    public void testmaxDistToClosest() {
        MaximizeDistancetoClosestPerson s = new MaximizeDistancetoClosestPerson();
        int[] seats;
        int expect;
        int output;
        int seq = 0;

        seats = new int[]{1, 0, 0, 0, 1, 0, 1};
        expect = 2;
        output = s.maxDistToClosest(seats);
        verify(expect, output, seq++);


        seats = new int[]{1, 0, 0, 0};
        expect = 3;
        output = s.maxDistToClosest(seats);
        verify(expect, output, seq++);

        seats = new int[]{0, 0, 1, 0, 1, 1};
        expect = 2;
        output = s.maxDistToClosest(seats);
        verify(expect, output, seq++);


        seats = new int[]{0, 1, 0, 1, 0};
        expect = 1;
        output = s.maxDistToClosest(seats);
        verify(expect, output, seq++);
    }
}
