package reverselist;

public class Solution {
    public ListNode ReverseListRevesion(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode rHead = ReverseListRevesion(head.next);

        head.next.next = head;
        head.next = null;

        return rHead;
    }
    public ListNode ReverseList(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode rhead = head;
        head = head.next;
        rhead.next = null;
        while(head.next != null){
            ListNode temp = head.next;
            head.next = rhead;
            rhead = head;
            head = temp;
        }

        head.next = rhead;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode head = l1;
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = l1.next;
        l1.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode rList = solution.ReverseList(head);

    }
}

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}