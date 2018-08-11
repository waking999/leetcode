package leetcode.success.stack;

import common.Util;
import leetcode.success.stack.ReconstructItinerary;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReconstructItineraryTest {
    @Test
    public void test1() {
        ReconstructItinerary s = new ReconstructItinerary();

        String[][] tickets;
        List<String> output;
        String[] expect;
        int seq = 1;

        tickets = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        expect = new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"};
        output = s.findItinerary(tickets);
        Util.verifyUnsort(expect, output, seq++);


        tickets = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        expect = new String[]{"JFK", "ATL", "JFK", "SFO", "ATL", "SFO"};
        output = s.findItinerary(tickets);
        Util.verifyUnsort(expect, output, seq++);

        tickets = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"} };
        expect = new String[]{"JFK","NRT", "JFK","KUL",};
        output = s.findItinerary(tickets);
        Util.verifyUnsort(expect, output, seq++);
    }
}
