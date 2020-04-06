package com.company.sort;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {0,4,10,5,11,5};
        int[] arr1 = {1,0,2,3};
        optimized_method(arr);
        System.out.println(Arrays.toString(arr));

    }

    // exchange simply
    private static void method_1(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j])swap(arr,i,j);
            }
        }
    }

    // normal bubble
    private static void method_2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length-1; j >= i ; j--) {
                if(arr[j-1]>arr[j])swap(arr,j,j-1);
            }
        }
    }

    // no compare after arr has sortable
    private static void optimized_method(int[] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = arr.length-1; j > i; j--) {
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                    flag=true;
                }
            }
        }
    }



    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
