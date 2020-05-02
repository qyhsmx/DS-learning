package com.company;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class StringReverse {
    public static void main(String[] args) {

    }
    private static void reverseArray(char[] arr){
        int i = 0,j = arr.length-1;
        while (i < j){
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
