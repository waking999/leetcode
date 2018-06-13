package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int seatsLen = seats.length;
        int maxDis = 1;

        int left = -1;
        int start = 1;

        if (seats[0] == 1) {
            left = 0;
            start = 0;
        }

        for (int i = start; i < seatsLen ; i++) {
            if (seats[i] == 1) {
                int leftDis = i - left;
                if(left==-1){
                    leftDis=(leftDis-1)*2;
                }
                maxDis = Math.max(maxDis, leftDis);
                left = i;
            }
        }


        if (left != seatsLen - 1) {
            int leftDis = (seatsLen - 1 - left)*2;
            maxDis = Math.max(leftDis, maxDis);
        }


        return maxDis / 2;

    }

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
        Util.verify(expect, output, seq++);


        seats = new int[]{1, 0, 0, 0};
        expect = 3;
        output = s.maxDistToClosest(seats);
        Util.verify(expect, output, seq++);

        seats = new int[]{0, 0, 1, 0, 1, 1};
        expect = 2;
        output = s.maxDistToClosest(seats);
        Util.verify(expect, output, seq++);


        seats = new int[]{0, 1, 0, 1, 0};
        expect = 1;
        output = s.maxDistToClosest(seats);
        Util.verify(expect, output, seq++);
    }
}
