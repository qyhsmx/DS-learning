package com.company.hashAndSet;

import java.util.*;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,1};
        int val = 0;
        //System.out.println(Arrays.toString(sum(arr,val)));
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    private static Integer[] sum(int[] arr,int val){
        if(arr.length<2)return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            //if not contains
           if(!map.containsKey(val-arr[i])){
               map.put(arr[i],i);
           }
           //if contains
           else {
               return new Integer[]{map.get(val-arr[i]),i};
           }
        }
        return null;
    }


}
