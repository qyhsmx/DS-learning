package com.company.sort;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,1,0,5,10,4};
        //quickSort(arr,0,arr.length-1);
        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int l,int r){
        if(l>=r)return;
        int i = l , j = r;
        int temp = arr[i];
        while (i < j){
            // j move to left until arr[j]<temp
            while(i < j && arr[j] >= temp){
                j--;
            }
            // i move to right until arr[i]>temp
            while (i < j && arr[i] <= temp){
                i++;
            }
            //now exchange arr[j] arr[i]
            if(i<j){
                int p = arr[j];
                arr[j] = arr[i];
                arr[i] = p;
            }
        }
        // exchange base point
        arr[l] = arr[i];
        arr[i] = temp;

        // do same thing in left and right
        quickSort(arr,0,i-1);
        quickSort(arr,i+1,r);

    }

    private static void quick_sort(int[] arr,int low,int high){
        int pivot;
        if(low < high){
            pivot = partition(arr,low,high);
            quick_sort(arr,0,pivot-1);
            quick_sort(arr,pivot+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotKey = arr[low];

        while (low < high){
            while (low < high && arr[high] >= pivotKey){
                high--;
            }
            swap(arr,low,high);
            while (low < high && arr[low] <= pivotKey){
                low++;
            }
            swap(arr,low,high);
        }
        return low;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
