package linktoarray;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> aList = new ArrayList<>();
//        if (listNode != null) {
//            do {
//                aList.add(0, listNode.val);
//            } while (listNode.next != null);
//        }
//        return aList;

        while(listNode != null){
            aList.add(0,listNode.val);
            listNode = listNode.next;
        }
        return aList;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
//        ListNode nNull = new ListNode();
        n1.next = n2;
        ArrayList<Integer> aList = printListFromTailToHead(n1);
//        for(int i : aList){
//            System.out.println(i);
//        }
        System.out.println(printListFromTailToHead(n1).toString());
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
