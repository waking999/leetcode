package leetcode.success.other;

import java.util.List;

import static common.Util.verify;

public class EmployeeImportanceTest {
    public static void main(String[] args) {
        EmployeeImportance s = new EmployeeImportance();

        int[] ids;
        int[] imps;
        int[][] subs;
        List<Employee> employees;
        int id;
        int expect;
        int output;
        int seq = 0;

        ids = new int[]{1, 2, 3};
        imps = new int[]{5, 3, 3};
        subs = new int[][]{{2, 3}, null, null};
        employees = s.getEmployees(ids, imps, subs);
        id = 1;
        expect = 11;
        output = s.getImportance(employees, id);
        verify(expect, output, ++seq);

        ids = new int[]{1, 2, 3};
        imps = new int[]{5, 3, 3};
        subs = new int[][]{{2, 3}, null, null};
        employees = s.getEmployees(ids, imps, subs);
        id = 2;
        expect = 3;
        output = s.getImportance(employees, id);
        verify(expect, output, ++seq);

        ids = new int[]{1, 2, 3};
        imps = new int[]{15, 10, 5};
        subs = new int[][]{{2}, {3}, null};
        employees = s.getEmployees(ids, imps, subs);
        id = 1;
        expect = 30;
        output = s.getImportance(employees, id);
        verify(expect, output, ++seq);

        ids = new int[]{1, 2, 3};
        imps = new int[]{15, 10, 5};
        subs = new int[][]{{2}, {3}, null};
        employees = s.getEmployees(ids, imps, subs);
        id = 2;
        expect = 15;
        output = s.getImportance(employees, id);
        verify(expect, output, ++seq);

        ids = new int[]{1, 2, 3};
        imps = new int[]{15, 10, 5};
        subs = new int[][]{{2}, {3}, null};
        employees = s.getEmployees(ids, imps, subs);
        id = 3;
        expect = 5;
        output = s.getImportance(employees, id);
        verify(expect, output, ++seq);

        ids = new int[]{101, 2};
        imps = new int[]{3, 5};
        subs = new int[][]{{}, {101}};
        employees = s.getEmployees(ids, imps, subs);
        id = 2;
        expect = 8;
        output = s.getImportance(employees, id);
        verify(expect, output, ++seq);

    }

}
