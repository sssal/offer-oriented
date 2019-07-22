package randomlistnode;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode pHeadCopy = pHead;
        while (pHeadCopy != null) {
            RandomListNode temp = new RandomListNode(pHeadCopy.label);
            temp.next = pHeadCopy.next;
            pHeadCopy.next = temp;
            pHeadCopy = pHeadCopy.next.next;
        }

        pHeadCopy = pHead;
        while (pHeadCopy != null) {
            pHeadCopy.next.random = pHeadCopy.random == null ? null : pHeadCopy.random.next;
            pHeadCopy = pHeadCopy.next.next;
        }


        pHeadCopy = pHead;
        RandomListNode nHead = pHead.next;
        while (pHeadCopy != null) {
            RandomListNode temp = pHeadCopy.next;
            pHeadCopy.next = pHeadCopy.next.next;
            temp.next = pHeadCopy.next == null ? null : pHeadCopy.next.next;
            pHeadCopy = pHeadCopy.next;
        }

        return nHead;
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n5;
        n2.random = n4;

        Solution solution = new Solution();
        solution.Clone(n1);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}