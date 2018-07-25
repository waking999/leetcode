package leetcode.attempt;

import java.util.*;

/**
 * https://leetcode.com/problems/accounts-merge/description/
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 * <p>
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts==null){
            return null;
        }
        int accountsLen=accounts.size();
        List<List<String>> rtn=new ArrayList<>();
        if(accountsLen==0){
            return rtn;
        }
        Set<Wrap> set = new HashSet<>();

        for (List<String> account : accounts) {
            int accountLen = account.size();
            String name = account.get(0);
            Wrap w = new Wrap(name);
            for (int i = 1; i < accountLen; i++) {
                w.addEmail(account.get(i));
            }
            if (set.contains(w)) {
                Iterator<Wrap> it = set.iterator();
                boolean found = false;
                while (it.hasNext() && !found) {
                    Wrap a = it.next();
                    if (a.equals(w)) {
                        for (int i = 1; i < accountLen; i++) {
                            a.addEmail(account.get(i));
                        }
                        found = true;
                    }
                }
            }else{
                set.add(w);
            }
        }


        Iterator<Wrap> it = set.iterator();
        while (it.hasNext()){
            List<String> l=new ArrayList<>();
            Wrap w=it.next();
            l.add(w.name);
            for(String email:w.emails){
                l.add(email);
            }
            Collections.sort(l);
            rtn.add(l);
        }
        return rtn;
    }

    class Wrap {
        String name;
        Set<String> emails;

        Wrap(String name) {
            this.name = name;
            this.emails = new HashSet<>();
        }

        void addEmail(String email) {
            emails.add(email);
        }

        @Override
        public boolean equals(Object b) {
            if (b == null) {
                return false;
            }
            if (!(b instanceof Wrap))
                return false;
            if (b == this) {
                return true;
            }
            if (!this.name.equals(((Wrap) b).name)) {
                return false;
            }
            for (String aEamil : this.emails) {
                for (String bEmail : ((Wrap) b).emails) {
                    if (aEamil.equals(bEmail)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return -1;
        }
    }
}
