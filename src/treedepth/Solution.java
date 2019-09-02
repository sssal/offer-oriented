package treedepth;

public class Solution {
    int deepth = 0;
    public int TreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        dfs(root, 1);
        return deepth;
    }

    public  void dfs(TreeNode root, int val){
        if(root != null){
            root.val = val;
            deepth = Math.max(deepth, val);
            dfs(root.left, root.val+1);
            dfs(root.right, root.val+1);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        TreeNode node = root;
//        node = root.right;
//        node.left = new TreeNode(4);
//        node.right = new TreeNode(5);
//        node = node.left;
//        node.left = new TreeNode(6);
//        node = node.left;
//        node.right = new TreeNode(7);
        Solution solution = new Solution();
        int deepth = solution.TreeDepth(root);
        System.out.println(deepth);
    }
}

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val){
        this.val = val;
    }

}