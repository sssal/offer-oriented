package mergelist;

public class Solution {
    public ListNode MergeRecursion(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = MergeRecursion(list1.next, list2);
            return list1;
        }else{
            list2.next = MergeRecursion(list1, list2.next);
            return list2;
        }
    }
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode merge = null;
        if(list1.val <= list2.val){
            merge = list1;
            list1 = list1.next;
        }else{
            merge = list2;
            list2 = list2.next;
        }
        ListNode head = merge;
        while (list1 != null && list2 != null) {
//            merge = list1.val >= list2.val ? list1 : list2;
            if(list1.val <= list2.val){
                merge.next = list1;
                list1 = list1.next;
            }else{
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }
        if(list1 == null){
            merge.next = list2;
        }else if(list2 == null){
            merge.next = list1;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}