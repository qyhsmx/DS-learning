package com.company.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class ShootBallon {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{5,7},{8,10}};
        System.out.println(minShootNum(arr));
    }
    // 数组的每一个元素是一个两个元素的数组
    private static int minShootNum(int[][] arr){
        // 按坐标的第一个元素由小到大排序
        Arrays.sort(arr, Comparator.comparingInt(m -> m[0]));
        int shoot_num = 1;
        int shoot_begin = arr[0][0];
        int shoot_end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if(shoot_end >= arr[i][0]){
                shoot_begin = arr[i][0];
                if(shoot_end>arr[i][1]){
                    shoot_end = arr[i][1];
                }
            }
            else {
                shoot_num++;
                shoot_begin = arr[i][0];
                shoot_end = arr[i][1];
            }
        }
        return shoot_num;
    }
}
