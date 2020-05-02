package com.company.hashAndSet;

import java.util.*;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {3,1,-1,1,0,5,7};
        int val = 0;
        //System.out.println(method(arr,val));
        System.out.println(method1(arr,val));

    }
    private static List<Integer> method1(int[] arr, int val){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i]==arr[i-1])continue;
            int l = i+1;
            int r = arr.length-1;
            while (l<r){
                int sum = arr[i] + arr[l] + arr[r];
                if(sum>val)r--;
                else if(sum<val)l++;
                else{
                    list.add(arr[i]);
                    list.add(arr[l]);
                    list.add(arr[r]);
                    while (l<r && arr[l] == arr[l+1])l++;
                    while (l<r && arr[r] == arr[r-1])r--;
                    l++;r--;
                }
            }
        }
        return list;
    }

    private static Set<Integer> method(int[] arr, int val){
        Map<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(i>=1&&arr[i]==arr[i-1])continue;
            for (int j = i+1; j < arr.length; j++) {
                if(!map.containsKey(val-arr[i]-arr[j])){
                    map.put(arr[i]+arr[j],1);
                }else {
                    set.addAll(Arrays.asList(arr[i], arr[j], val - arr[i] - arr[j]));
                    return set;
                }
            }
        }
        return set;
    }
}
