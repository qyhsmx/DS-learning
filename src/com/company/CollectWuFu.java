package com.company;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class CollectWuFu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        int[] arr = new int[5];
        for (String s : split)
        {
            char[] chars = s.toCharArray();
            for (int i=0; i< chars.length; i++)
            {
                if(chars[i] == '1'){
                    arr[i]++;
                }
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
