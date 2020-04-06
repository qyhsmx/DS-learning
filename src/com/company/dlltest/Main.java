package com.company.dlltest;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class Main {
    //test arrays copyOfRange
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[2];
        // range is [)
        int[] range = Arrays.copyOfRange(arr1, 0, 3);
        System.out.println(Arrays.toString(range));
    }

    // test system arraycopy
    public static void main1(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[2];
        // from arr1 to arr2 ,pos is beginIndex,
        // length is that how long we copy
        System.arraycopy(arr1,0,arr2,0,2);
        System.out.println(Arrays.toString(arr2));
    }
}
