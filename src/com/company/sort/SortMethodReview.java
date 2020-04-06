package com.company.sort;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class SortMethodReview {
    public static void main(String[] args) {
        int[] arr = {0,4,3,10,3,5,1,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length;i++){

            for (int j  =i+1;j < arr.length;j++){

                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    private static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            int temp = arr[i];
            while (j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    //heap sort
    public static class HeapSort{

        public static void main(String[] args) {
            int[] arr = {0,4,3,10,3,5,1,2};
            heapSort(arr);
            System.out.println(Arrays.toString(arr));
        }

        static void heapSort(int[] arr){
            build_heap(arr,arr.length);
            for(int i=arr.length-1;i>=0;i--){
                swap(arr,i,0);
                heapify(arr,i,0);
            }
        }

        static void build_heap(int[] arr,int n){
            int last_node_index = n-1;
            int begin_heapify_index = (last_node_index-1)>>1;
            for(int i = begin_heapify_index;i>=0;i--){
                heapify(arr,n,i);
            }
        }

        //heap a big value first heap
        static void heapify(int[] arr, int len, int i){
            if(i>=len)return;
            //left and right children
            int c1 = 2*i+1;
            int c2 = 2*i+2;

            //temp max value
            int max = i;
            if(c1<len && arr[c1]>arr[max]){
                max = c1;
            }
            if(c2<len && arr[c2]>arr[max]){
                max = c2;
            }
            if(max!=i){
                swap(arr,i,max);
                heapify(arr,len,max);
            }

        }

        private static void swap(int[] arr, int i, int max) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }

    }
}
