package hassubtree;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        boolean result = true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue2.isEmpty()) {
            TreeNode node2 = queue2.poll();
            TreeNode node1 = queue1.poll();
            if (node1.val != node2.val) {
                result = false;
                break;
            }
            if (node2.left != null) {
                if (node1.left == null) {
                    result = false;
                    break;
                }
                queue2.offer(node2.left);
                queue1.offer(node1.left);
            }
            if (node2.right != null) {
                if (node1.right == null) {
                    result = false;
                    break;
                }
                queue2.offer(node2.right);
                queue1.offer(node1.right);
            }
        }

        return result;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        if (root1 == null) {
            return false;
        }
        boolean result = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (root2.val == node.val) {
                result = isSameTree(node, root2);
                if (result) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(solution.HasSubtree(root2, root1));
    }
}

class SolutionRecursive {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            result = isSameTree(root1, root2);
            if(result){
                return true;
            }
        }
        if(root1.left != null){
            result = HasSubtree(root1.left, root2);
            if(result){
                return true;
            }
        }
        if(root1.right != null){
            result = HasSubtree(root1.right, root2);
            if(result){
                return true;
            }
        }


        return false;
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        boolean result = true;
        if (root2.val != root1.val) {
            return false;
        }
        if (root2.left != null) {
            if(root1.left == null){
                return false;
            }
            result = isSameTree(root1.left, root2.left);
        }

        if(root2.right != null){
            if(root1.right == null){
                return false;
            }
            result = result && isSameTree(root1.right, root2.right);
        }


        return result;
    }


}

class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}