package com.company;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class TrimDuplicatedNum {
    public static void main(String[] args) {
        trim("aabbcaa");
    }
    private static void trim(String str){
        char[] arr = str.toCharArray();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < arr.length)
        {
            while (j < arr.length && arr[i]==arr[j] )
                j++;
            sb.append(arr[i]);
            sb.append(j-i);
            i = j;
        }
        System.out.println(sb.toString());
    }
}
