package yongyou;

import java.util.Scanner;

public class Main {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] strings = input.split(",");
        String pre = strings[0];
        String mid = strings[1];
        TreeNode head = rebuild(pre, mid);
        postOrderTraverse(head);
        System.out.println(result);

    }
    public static TreeNode rebuild(String pre, String mid){
        return rebuild(pre.toCharArray(),0,pre.length()-1,
                        mid.toCharArray(),0,mid.length()-1);
    }

    private static TreeNode rebuild(char[] pre, int preStart, int preEnd,
                                 char[] mid, int midStart, int midEnd){
        if(preStart > preEnd || midStart > midEnd){
            return null;
        }
        TreeNode head = new TreeNode(pre[preStart]);
        for(int i = midStart; i<=midEnd; i++){
            if(pre[preStart] == mid[i]){
                head.left = rebuild(pre, preStart+1, i-midStart + preStart,
                                    mid, midStart, i-1);
                head.right = rebuild(pre,i-midStart + preStart +1, preEnd,
                                    mid, i+1, midEnd);
                break;
            }
        }
        return head;
    }

    public static void postOrderTraverse(TreeNode root){
        if(root.left != null){
            postOrderTraverse(root.left);
        }
        if(root.right != null){
            postOrderTraverse(root.right);
        }
        result.append(root.val);

    }

}

class TreeNode{
    char val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(char c){
        val = c;
    }
}
