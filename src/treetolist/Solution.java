package treetolist;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = pRootOfTree;
        TreeNode listNode = null;
        TreeNode pre = null;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.offerFirst(temp);
                temp = temp.left;
            } else {
                temp = stack.pollFirst();
                temp.left = pre;
                if (pre == null) {
                    listNode = temp;
                }
                if (pre != null) {
                    pre.right = temp;
                }
                pre = temp;
                temp = temp.right;
            }
        }
        return listNode;
    }

    public TreeNode ConvertRecursive(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }
        convertHelper(pRootOfTree);
        while(pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;

    }

    private void convertHelper(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return;
        }
        convertHelper(pRootOfTree.left);
        pRootOfTree.left = pre;
        if(pre != null) {
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;

        convertHelper(pRootOfTree.right);


    }

    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(8);
//        TreeNode n5 = new TreeNode(10);
        TreeNode n6 = new TreeNode(14);
        TreeNode n7 = new TreeNode(12);
        TreeNode n8 = new TreeNode(16);
        n1.left = n2;
        n1.right = n6;

        n2.left = n3;
        n2.right =n4;

        n6.left = n7;
        n6.right = n8;

        solution.ConvertRecursive(n1);
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}