package com.company.search;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class SortableSearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,1,7};
        System.out.println(search(arr,3));
    }
    private static int search(int[] arr,int key){
        int n = arr.length-1;
        while(arr[n]!=key){
            n--;
        }
        return n;
    }

}
