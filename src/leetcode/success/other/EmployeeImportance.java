package leetcode.success.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, EmpImp> map = new HashMap<>(employees.size());
        constructEmpImp(employees, map);
        return map.get(id).imp;
    }

    private void constructEmpImp(List<Employee> employees, Map<Integer, EmpImp> map) {
        for (Employee e : employees) {
            int id = e.id;
            int imp = e.importance;
            if (!map.containsKey(id)) {
                EmpImp ei = new EmpImp(id, imp);
                map.put(id, ei);
            } else {
                EmpImp ei = map.get(id);
                if (ei.imp == 0) {
                    ei.imp = imp;
                }
                EmpImp parent = ei.parent;
                while (parent != null) {
                    parent.imp += imp;
                    parent = parent.parent;
                }

            }
            List<Integer> subordinates = e.subordinates;
            for (int sub : subordinates) {
                EmpImp child = null;
                if (map.containsKey(sub)) {
                    child = map.get(sub);
                } else {
                    child = new EmpImp(sub);
                    map.put(sub, child);
                }

                child.parent = map.get(id);
                if (child.imp != 0) {
                    EmpImp parent = child.parent;
                    while (parent != null) {
                        parent.imp += child.imp;
                        parent = parent.parent;
                    }
                }
            }
        }
    }

    private Employee getEmployee(int id, int importance, int[] sub) {
        Employee e = new Employee();
        e.id = id;
        e.importance = importance;
        List<Integer> subordinates = new ArrayList<>();
        if (sub != null) {
            for (int s : sub) {
                subordinates.add(s);
            }
        }
        e.subordinates = subordinates;
        return e;
    }

    List<Employee> getEmployees(int[] ids, int[] imps, int[][] subs) {

        int idsLen = ids.length;
        List<Employee> ret = new ArrayList<>(idsLen);

        for (int i = 0; i < idsLen; i++) {
            Employee e = getEmployee(ids[i], imps[i], subs[i]);
            ret.add(e);
        }
        return ret;
    }

    class EmpImp {
        private int id;
        private int imp;

        EmpImp parent;

        EmpImp(int id, int imp) {
            this.id = id;
            this.imp = imp;
        }

        EmpImp(int id) {
            this.id = id;
            this.imp = 0;
        }

        public String toString() {
            return id + ":" + imp;
        }
    }

}

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
