package binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public void preOrderTraverse(TreeNode root) {
//        System.out.print(root.val + " ");
//        if (root.left != null) {
//            preOrderTraverse(root.left);
//        }
//        if (root.right != null) {
//            preOrderTraverse(root.right);
//        }
//
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    public void preOrderTraverseNoRecursive(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.val + " ");
                stack.addFirst(node);
                node = node.left;
            } else {
                node = stack.removeFirst();
                node = node.right;

            }

        }
    }


    public void inOrderTraverse(TreeNode root) {
        if (root.left != null) {
            inOrderTraverse(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {

            inOrderTraverse(root.right);
        }
    }

    public void inOrderTraverseNoRecursive(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.addFirst(node);
                node = node.left;
            } else {
                node = stack.removeFirst();
                System.out.print(node.val + " ");
                node = node.right;

            }

        }
    }

    public void postOrderTraverseNoRecursive(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode tabel = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.addFirst(node);
                node = node.left;
            } else {
                node = stack.getFirst();
                if(node.right != null && node.right != tabel ){
                    node = node.right;
                }else {
                    stack.removeFirst();
                    System.out.print(node.val + " ");
//                    node = node.right;
                    tabel = node;
                    node = null;
                }
            }

        }
    }
    public void postOrderTraverse(TreeNode root) {
        if (root.left != null) {
            postOrderTraverse(root.left);
        }
        if (root.right != null) {
            postOrderTraverse(root.right);
        }
        System.out.print(root.val + " ");
    }

    public void bfs(TreeNode root){
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                System.out.print(temp.val + " ");
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.right = new TreeNode(6);

        binaryTree.preOrderTraverse(tree1);
        System.out.println();
        binaryTree.preOrderTraverseNoRecursive(tree1);
        System.out.println();
        binaryTree.inOrderTraverse(tree1);
        System.out.println();
        binaryTree.inOrderTraverseNoRecursive(tree1);
        System.out.println();
        binaryTree.postOrderTraverse(tree1);
        System.out.println();
        binaryTree.postOrderTraverseNoRecursive(tree1);
        System.out.println();
        binaryTree.bfs(tree1);
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
        this.val = val;
    }
}