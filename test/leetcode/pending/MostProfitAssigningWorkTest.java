package leetcode.pending;

import common.Util;
import leetcode.pending.MostProfitAssigningWork;
import org.junit.jupiter.api.Test;

public class MostProfitAssigningWorkTest {
    @Test
    public void test1() {
        MostProfitAssigningWork s = new MostProfitAssigningWork();


        int[] difficulty;
        int[] profit;
        int[] worker;
        int expect;
        int output;
        int seq = 1;


        difficulty = new int[]{2, 4, 6, 8, 10};
        profit = new int[]{10, 20, 30, 40, 50};
        worker = new int[]{4, 5, 6, 7};
        expect = 100;
        output = s.maxProfitAssignment(difficulty, profit, worker);
        Util.verify(expect, output, seq++);


        difficulty = new int[]{13,37,58};
        profit = new int[]{4,90,96};
        worker = new int[]{34,73,45};
        expect = 190;
        output = s.maxProfitAssignment(difficulty, profit, worker);
        Util.verify(expect, output, seq++);



        difficulty = new int[]{85,47,57};
        profit = new int[]{24,66,99};
        worker = new int[]{40,25,25};
        expect = 0;
        output = s.maxProfitAssignment(difficulty, profit, worker);
        Util.verify(expect, output, seq++);



        difficulty = new int[]{68,35,52,47,86};
        profit = new int[]{67,17,1,81,3};
        worker = new int[]{92,10,85,84,82};
        expect = 324;
        output = s.maxProfitAssignment(difficulty, profit, worker);
        Util.verify(expect, output, seq++);



        difficulty = new int[]{23,30,35,35,43,46,47,81,83,98};
        profit = new int[]{8,11,11,20,33,37,60,72,87,95};
        worker = new int[]{95,46,47,97,11,35,99,56,41,92};
        expect = 553;
        output = s.maxProfitAssignment(difficulty, profit, worker);
        Util.verify(expect, output, seq++);

    }

}
