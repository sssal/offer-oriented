package hassubtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//import hassubtree.TreeNode;

class SolutionTest {
    Solution solution = new Solution();
    SolutionRecursive solutionRecursive = new SolutionRecursive();

    @Test
    public void test1(){
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        assertTrue(solution.isSameTree(root2,root2));
        assertTrue(solution.isSameTree(root2,root1));
        assertFalse(solution.isSameTree(root1,root2));
        assertTrue(solution.HasSubtree(root2,root1));
    }


    @Test
    public void test2(){
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        assertTrue(solutionRecursive.isSameTree(root2,root2));
        assertTrue(solutionRecursive.isSameTree(root2,root1));
        assertFalse(solutionRecursive.isSameTree(root1,root2));
        assertTrue(solution.HasSubtree(root2,root1));
    }



}

