package com.company.sort;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {0,4,10,5,11,5};
        int[] arr1 = {1,0,2,3};
        method(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void method(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
