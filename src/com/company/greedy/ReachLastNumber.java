package com.company.greedy;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class ReachLastNumber {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(reachLast(arr));
    }
    private static boolean reachLast(int[] arr){
        int[] pace = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pace[i] = i+arr[i];
        }
        int position = 0;
        int max_pace = pace[0];
        while(position < pace.length && position < max_pace){
            if(max_pace<pace[position]) {
                max_pace = pace[position];
            }
            position++;
        }
        return position==pace.length;
    }

}
