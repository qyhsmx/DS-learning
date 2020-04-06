package com.company.sort;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4,1,10,5,0,3};
        method(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void method(int[] arr){
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min]>arr[j])min=j;
            }
            if(min!=i)swap(arr,i,min);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
