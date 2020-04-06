package com.company.greedy;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class TheMinPaceReachLastNum {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,0,5,6,9};
        int[] arr2 = {4,6,1,7,8};
        System.out.println(reachLast(arr));
    }

    private static int reachLast(int[] arr){

        //当前能达到的最大索引处
        int currMaxIndex =  arr[0];
        //当前位置前能达到的最大索引处
        int preMaxIndex = arr[0];
        //最小次数
        int min = 1;

        if(arr.length<2){
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            //当 当前索引大于当前能跳到的最大索引处
            if(i > currMaxIndex){
                min++;
                currMaxIndex = preMaxIndex;
            }
            // 更新之前的值可以到达的最远索引处
            if(arr[i]+i > preMaxIndex){
                preMaxIndex = arr[i]+i;
            }
        }

        return min;
    }
}
