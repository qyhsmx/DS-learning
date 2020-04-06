package com.company.sort;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] sortable_arr = {6,7,8,1,2,3};
        int[] arr = {4,1,2,1,9,0,11,7};
        //merge(sortable_arr,0,sortable_arr.length-1,sortable_arr.length/2);
        //System.out.println(Arrays.toString(sortable_arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("result array is -> "+Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r){
        if(l==r){
            return;
        }
        else {
            int mid = (l+r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, r, mid+1);
        }
    }
    private static void merge(int[] arr,int l,int r,int m){
        // l -> left r -> right m -> mid
        //create tow sub array
        int[] left_array = new int[m-l];
        int[] right_array = new int[r-m+1];

        //init sub array
        System.arraycopy(arr,l,left_array,0,m-l);
        System.arraycopy(arr,m,right_array,0,r-m+1);

        /*---------------------*/
        System.out.println("left_array is "+ Arrays.toString(left_array));
        System.out.println("right_array is "+ Arrays.toString(right_array));
        /*---------------------*/

        //merge two sub array
        int i = 0;
        int j = 0;
        int k = l;
        while(i < left_array.length && j < right_array.length){
            if(left_array[i]<right_array[j])
                arr[k++] = left_array[i++];
            else
                arr[k++] = right_array[j++];

        }

        while (i < left_array.length){
            arr[k++] = left_array[i++];
        }
        while (j < right_array.length){
            arr[k++] = right_array[j++];
        }
    }
}
