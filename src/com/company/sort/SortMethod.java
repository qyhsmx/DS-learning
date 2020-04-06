package com.company.sort;

import java.awt.*;
import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class SortMethod {
    public static void main(String[] args) {
        int[] arr = {10,3,1,6,8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // insert directly sort
    private static void insertSort(int[] arr){
        //这里假设第一个是已经排好序的
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            // 用临时变量不断与其前面排好序的比较，
            // 遇到比temp大的则交换后移，空出一位
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            // 此时到一个不大于temp的值 temp 插入当前值的后一位
            arr[j+1] = temp;
        }
    }
    // selection sort
    private static void selectionSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j=i+1;j < len;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    // bubble sort
    private static void bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for(int j = 0;j < len-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    // quick sort
    private static void quickSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int i = start;
        int j = end;
        int pivot = arr[i];
        while (i<j){
            while(arr[j]>=pivot && i<j){
                j--;
            }
            while (arr[i]<=pivot && i<j){
                i++;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[start] = arr[i];
        arr[i] = pivot;
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }
    // heap sort
    public static class HeapSort{
        private static void heapSort(int[] tree,int n){
            buildHeap(tree,n);
            for (int i=n-1;i>=0;i--){
                swap(tree,i,0);
                heapify(tree,i,0);
            }
        }
        private static void buildHeap(int[] tree,int n){
            int last_node = n-1;
            int parent = (last_node-1)/2;
            for (int i=parent;i>=0;i--){
                heapify(tree,n,i);
            }
        }

        private static void heapify(int[] tree,int n,int i){
            if(i>=n)return;
            int c1 = 2*i+1;
            int c2 = 2*i+2;
            int max = i;
            if(c1<n && tree[c1]>tree[max]){
                max = c1;
            }
            if(c2<n && tree[c2]>tree[max]){
                max = c2;
            }
            if(max!=i){
                swap(tree,max,i);
                heapify(tree,n,max);
            }

        }
        private static void swap(int[] tree,int a,int b){
            int temp = tree[a];
            tree[a] = tree[b];
            tree[b] = temp;
        }
    }
}
