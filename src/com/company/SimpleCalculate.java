package com.company;

import java.util.Stack;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class SimpleCalculate {

    public static void main(String[] args) {
        String str = "1+4*5-8/3";
        System.out.println(cal(str));

    }
    //定义两个栈 数字栈 操作符栈
    //数字和+/-直接入栈
    //*/ /数字出站做运算 在入栈
    private static int cal(String str){
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opsStack = new Stack<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++)
        {
            char c = arr[i];
            if(c >= '0' && c <= '9')
                numStack.push(Integer.parseInt(String.valueOf(c)));
            else if (c == '-' || c == '+')
                opsStack.push(c);
            else {
                //* and /
                int left = numStack.pop();
                int right = Integer.parseInt(String.valueOf(arr[++i]));
                if(c == '*'){
                    numStack.push(left*right);
                }
                else {
                    numStack.push(left/right);
                }
            }
        }
        while (!opsStack.empty())
        {
            char op = opsStack.pop();
            int a = numStack.pop();
            int b = numStack.pop();
            if(op == '+')
                numStack.push(a+b);
            else
                numStack.push(b-a);
        }
        return numStack.pop();
    }
}
