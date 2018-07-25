package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountsMergeTest {
    @Test
    public void test1() {
        AccountsMerge s = new AccountsMerge();

        List<List<String>> accounts;
        List<List<String>> output;
        String[][] expect;
        int seq = 1;

        accounts = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("John");
        l1.add("johnsmith@mail.com");
        l1.add("john00@mail.com");
        accounts.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("John");
        l2.add("johnnybravo@mail.com");
        accounts.add(l2);
        List<String> l3 = new ArrayList<>();
        l3.add("John");
        l3.add("johnsmith@mail.com");
        l3.add("john_newyork@mail.com");
        accounts.add(l3);
        List<String> l4 = new ArrayList<>();
        l4.add("Mary");
        l4.add("mary@mail.com");
        accounts.add(l4);

        expect = new String[][]{{"John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"}, {"John", "johnnybravo@mail.com"}, {"Mary", "mary@mail.com"}};
        output = s.accountsMerge(accounts);
        Util.verifyUnsort(expect, output, seq++);


        String[][] input = new String[][]{{"David", "David0@m.co", "David1@m.co"}, {"David", "David3@m.co", "David4@m.co"}, {"David", "David4@m.co", "David5@m.co"}, {"David", "David2@m.co", "David3@m.co"}, {"David", "David1@m.co", "David2@m.co"}};
        accounts=convertArrayToList(input);
        expect=new String[][]{{"David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"}};
        output=s.accountsMerge(accounts);
        Util.verifyUnsort(expect, output, seq++);

    }

    private List<List<String>> convertArrayToList(String[][] input){
        List<List<String>> rtn=new ArrayList<>();
        for(String[] strs:input){
            List<String> l=new ArrayList<>();
            for(String s:strs){
                l.add(s);
            }
            rtn.add(l);
        }
        return rtn;
    }
}
