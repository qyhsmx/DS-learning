package com.company;

import java.util.HashMap;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class CountByCharacter {
    public static void main(String[] args) {
        String str = "huawei";
        System.out.println(count(str));
    }
    public static int count(String str) {
        char[] array = str.toCharArray();
        int len = array.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res+=Math.pow(26,len-i-1)*(array[i]-'a'+1);
        }
        return res;
    }

}
