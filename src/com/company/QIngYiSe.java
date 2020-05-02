package com.company;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class QIngYiSe {
    public static void main(String[] args) {


    }
    private static boolean judge(String str){
        if(str.length()>14 || str.length()%3!=2)return false;
        //对子 + 顺子 + 刻子

        return true;
    }
}
