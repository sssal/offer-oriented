package minstack;

import java.util.Stack;

public class Solution {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else{
            if(node<=stack2.peek()){
                stack2.push(node);
            }
        }
    }

    public void pop(){
        if(stack1.peek().equals(stack2.peek())){
            stack2.pop();
        }
        stack1.pop();
    }

    public int top(){
        return stack1.peek();
    }

    public int min(){
        return stack2.peek();
    }

}
