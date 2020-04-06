package com.company.sort;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {0,4,1,10,5,11,5};
        int[] arr1 = {1,0,2,3};
        method(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void method(int[] arr){
        int incre = arr.length;
        while(incre>1) {
            incre = incre / 3 + 1;
            for (int i = incre; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - incre;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + incre] = arr[j];
                    j -= incre;
                }
                arr[j + incre] = temp;
            }
        }
    }
}

