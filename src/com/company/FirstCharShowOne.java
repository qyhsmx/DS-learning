package com.company;

import java.util.HashMap;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class FirstCharShowOne {
    public static void main(String[] args) {
        System.out.println(first("aasdd"));
    }
    public static String first(String str) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] array = str.toCharArray();
        for (char c : array)
        {
            map.put(c,!map.containsKey(c));
        }
        for (char c : array)
        {
            if(map.get(c))return c+"";
        }
        return "";
    }

}
