package mirrortree;

public class Solution {
    public void Mirror(TreeNode root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                TreeNode temp;
                temp = root.right;
                root.right = root.left;
                root.left = temp;
                if (root.left != null) {
                    Mirror(root.left);
                }
                if (root.right != null) {
                    Mirror(root.right);
                }
            }
        }
    }
}

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val){
        this.val = val;
    }
}