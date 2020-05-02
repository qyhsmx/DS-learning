package com.company;

import java.util.Arrays;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class TestArray {
    public static void main(String[] args) {
        System.out.println(11%10);
    }
    private static int method(int[] nums){
        int max = 0;
        int index = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                max = nums[i];
                index = i;
            }
        }
        for(int num:nums)
        {
            if(num<<1 > max)return -1;
        }
        return index;
    }
}
