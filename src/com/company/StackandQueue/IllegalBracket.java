package com.company.StackandQueue;


import java.util.HashMap;
import java.util.Stack;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
// judge double bracket
public class IllegalBracket {

    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(judge(str));
    }
    private static boolean judge(String str){
        char[] array = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (char c : array) {
            //now push left bracket into stack
            if (null == map.get(c)) {
                stack.push(c);
            }
            else if(stack.size()==0 || map.get(c)!=stack.pop()){
                return false;
            }
        }
        return true;
    }


    private static boolean judge_3(String str){
        int len = 0;
        do{
            len = str.length();
            str = str.replace("()","")
                    .replace("[]","")
                    .replace("{}","");

        }while (len!=str.length());
        return len == 0;
    }
}
