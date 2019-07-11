package binarytreerebuild;


//  Definition for binary tree
class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd,
                                           int[] in, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode head = new TreeNode(pre[preStart]);
        for(int i=inStart; i<=inEnd; i++){
            if(pre[preStart] == in[i]){
                head.left = reConstructBinaryTree(pre, preStart+1, i-inStart+preStart,
                                                    in, inStart, i-1);
                head.right = reConstructBinaryTree(pre, i-inStart+preStart+1, preEnd,
                                                    in, i+1, inEnd);
                break;
            }
        }
        return head;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

    }
}
