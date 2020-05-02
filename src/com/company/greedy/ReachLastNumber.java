package com.company.greedy;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class ReachLastNumber {
    public static void main(String[] args) {
        int[] arr = {1,4,1,1,1};
        //pace = [0+3,1+2,2+1,3+0,4+4] = [3,3,3,3,8] 当前位置能达到的最大索引处
        System.out.println(reachLast(arr));
    }
    private static boolean reachLast(int[] arr){
        int[] pace = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pace[i] = i+arr[i];
        }
        int position = 0;
        int max_pace = pace[0];
        while(position < pace.length && position <= max_pace){
            if(max_pace < pace[position]) {
                max_pace = pace[position];
            }
            position++;
        }
        return position==pace.length;
    }

}
