package findkthtotail;


import java.util.List;

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k){
        int n = 0;
        int kTh = n - k+1;
        ListNode kHead = head;
        while(head.next != null && kTh != 0){
            head = head.next;
            kTh++;
        }
        while(head.next != null){
            head = head.next;
            kHead = kHead.next;
        }
        if(kTh < 0) {
            return null;
        }

        return kHead;
    }

    public static void main(String[] args){
        ListNode l1 = null;

    }
}

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}