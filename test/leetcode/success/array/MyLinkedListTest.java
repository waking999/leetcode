package leetcode.success.array;

import common.Util;
import leetcode.success.array.MyLinkedList;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    @Test
    public void test1() {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        linkedList.get(1);            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        linkedList.get(1);            // returns 3
    }

    @Test
    public void test2() {
        String[] operations = new String[]{"MyLinkedList", "addAtHead", "addAtIndex", "get", "get", "get"};
        int[][] params = new int[][]{{}, {1}, {1, 2}, {1}, {0}, {2}};
        Integer[] expects = new Integer[]{null, null, null, 2, 1, -1};
        runTest(operations, params, expects);
    }

    @Test
    public void test3() {
        String[] operations = new String[]{"MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"};
        int[][] params = new int[][]{{},{0},{1,2},{0},{1},{0,1},{0},{1}};
        Integer[] expects = new Integer[]{null,-1,null,-1,-1,null,1,-1};
        runTest(operations, params, expects);
    }

    @Test
    public void test4() {
        String[] operations = new String[]{"MyLinkedList","addAtHead","get","addAtHead","addAtTail","get","addAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtIndex","addAtIndex","get","get","addAtIndex","get","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtIndex","addAtIndex","addAtHead","get","deleteAtIndex","addAtIndex","get","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","addAtHead","addAtTail","addAtTail","addAtIndex","get","get","addAtHead","deleteAtIndex","deleteAtIndex","get","deleteAtIndex","get","addAtIndex","addAtTail","addAtHead","addAtTail","addAtHead","get","addAtTail","addAtTail","addAtHead","get","get","addAtHead","addAtHead","addAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","addAtIndex","addAtTail","addAtIndex","get","addAtIndex","addAtIndex","get","addAtTail","addAtTail","addAtHead","addAtHead","addAtHead","deleteAtIndex","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","addAtIndex","get","addAtTail","addAtHead","addAtTail","addAtHead"};
        int[][] params = new int[][]{{},{56},{1},{41},{98},{3},{1,33},{72},{52},{89},{0},{98},{7,97},{2,51},{1},{6},{6,49},{8},{72},{7,8},{8,58},{10},{3,6},{9,61},{63},{16},{7},{16,55},{4},{10},{6},{96},{69},{20},{3},{44},{4},{8,16},{15},{21},{41},{1},{11},{21},{22},{2},{5,7},{62},{95},{91},{69},{24},{51},{94},{93},{29},{10},{68},{13},{32,42},{48},{55},{79},{5},{36},{32},{25,40},{8},{68},{30},{66},{92},{27,26},{90},{11,19},{68},{17,62},{15},{17,97},{35,89},{44},{90},{67},{2},{51},{30},{38},{30},{43},{76},{16},{38},{82},{81},{67},{67},{3,16},{57},{94},{11},{31},{50}};
        Integer[] expects = new Integer[]{null,null,-1,null,null,-1,null,null,null,null,null,null,null,null,0,41,null,33,null,null,null,null,null,null,null,97,null,null,6,8,null,null,null,null,null,null,null,null,41,96,null,null,null,20,null,63,null,null,null,null,null,20,null,null,null,51,6,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,69,null,null,51,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,90,null,null,null,null};
        runTest(operations, params, expects);
    }

    @Test
    public void test5() {
        String[] operations = new String[]{"MyLinkedList","addAtHead","get","addAtIndex","deleteAtIndex","get","addAtIndex","addAtHead","get","deleteAtIndex","get","addAtHead","get","addAtHead","addAtTail","addAtHead","get","addAtHead","addAtHead","get","addAtTail","get","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtIndex","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtTail","get","get","addAtHead","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtHead","addAtTail","addAtIndex","addAtTail","addAtHead","addAtTail","addAtHead","get","deleteAtIndex","deleteAtIndex","addAtIndex","addAtTail","addAtTail","deleteAtIndex","get","addAtHead","addAtIndex","addAtHead","addAtTail","addAtIndex","addAtTail","get","addAtHead","addAtHead","addAtTail","addAtTail","addAtHead","addAtHead","addAtIndex","addAtHead","addAtHead","addAtTail","addAtHead","get","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtTail","addAtIndex","get","addAtTail","get","addAtHead","get","addAtHead","get","get","addAtHead","get","addAtTail","deleteAtIndex","deleteAtIndex","addAtHead","deleteAtIndex","addAtHead","deleteAtIndex","addAtTail","addAtHead"};
        int[][] params = new int[][]{{},{56},{1},{1,50},{1},{1},{1,43},{82},{2},{3},{1},{41},{1},{44},{36},{57},{1},{64},{24},{4},{89},{5},{7},{33},{11},{24},{2,66},{91},{7},{48},{67},{32},{14},{12},{97},{91},{29},{6},{47},{69},{13},{88},{82},{4},{8},{8,85},{75},{56},{16},{51},{4},{13},{27},{11,62},{66},{10},{4},{28},{87},{22,99},{17},{30},{28,82},{17},{16},{76},{61},{36},{45},{31},{19},{2,73},{56},{58},{48},{87},{2},{4,49},{99},{81},{9,2},{39},{35,35},{19},{98},{50},{73},{22},{29},{6},{45},{13},{54},{42},{3},{8},{27},{16},{43},{39},{0},{23}};
        Integer[] expects = new Integer[]{null,null,-1,null,null,-1,null,null,43,null,56,null,82,null,null,null,44,null,null,41,null,82,null,null,null,null,null,null,null,null,null,null,91,89,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,47,null,null,null,null,null,null,66,null,null,null,null,null,null,56,null,null,null,null,null,null,null,null,null,null,null,56,null,null,null,null,null,null,48,null,48,null,24,null,19,16,null,99,null,null,null,null,null,null,null,null,null};
        runTest(operations, params, expects);
    }



    private void runTest(String[] operations, int[][] params, Integer[] expects) {
        MyLinkedList linkedList = null;
        int seq = 1;

        int len = operations.length;
        for (int i = 0; i < len; i++) {
            String op = operations[i];
            int[] param = params[i];
            if ("MyLinkedList".equals(op)) {
                linkedList = new MyLinkedList();
            } else if ("addAtHead".equals(op)) {
                linkedList.addAtHead(param[0]);
            } else if ("addAtIndex".equals(op)) {
                linkedList.addAtIndex(param[0], param[1]);
            } else if ("addAtTail".equals(op)) {
                linkedList.addAtTail(param[0]);
            }else if ("get".equals(op)) {
                int output = linkedList.get(param[0]);
                int expect = expects[i];
                Util.verify(expect, output, seq++);
            } else if ("deleteAtIndex".equals(op)) {
                linkedList.deleteAtIndex(param[0]);
            }
        }
    }

}
