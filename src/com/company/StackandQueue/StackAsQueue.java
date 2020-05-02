package com.company.StackandQueue;

import java.util.Stack;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class StackAsQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }



    private static class MyQueue{
        private Stack<Integer> in_stack = new Stack<>();
        private Stack<Integer> out_stack = new Stack<>();

        void push(int val){
            in_stack.push(val);
        }
        int pop(){
            if(out_stack.size()==0){
                if(in_stack.size()==0)
                    throw new RuntimeException("queue is null");
                while (in_stack.size()!=0){
                    out_stack.push(in_stack.pop());
                }
            }
            return out_stack.pop();
        }
    }
}
