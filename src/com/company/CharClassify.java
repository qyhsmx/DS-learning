package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class CharClassify {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        int c = scanner.nextInt(), b = scanner.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int x : a)
        {
            //to binary
            String binaryString = Integer.toBinaryString(x);
            //complete 0 in high position
            String hex = String.format("%08d", Integer.valueOf(binaryString));
            //split for 4 elements
            String[] split = split(hex);
            //get total
            int sum = sum(split);
            int t = sum % b;
            if (t < c){
                map.put(String.valueOf(t),map.getOrDefault(String.valueOf(t),0)+1);
            }
        }
        Integer orElse = map.values().stream().max(Integer::compareTo).orElse(0);
        System.out.println(orElse);
    }
    private static int sum(String[] arr){
        int res = 0;
        for (String s:arr)
        {
            res += Integer.parseInt(s,16);
        }
        return res;
    }
    private static String[] split(String str){
        String[] arr = new String[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.substring(0,2);
            str = str.substring(2);
        }
        return arr;
    }

    public static void main1(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int c = 5, b = 2;

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            String binaryA = Integer.toBinaryString(a[i]);
            String hexA = String.format("%08d", Integer.valueOf(binaryA));
            String[] splitHexA = split(hexA);

            int intA = 0;
            for (int j = 0; j < splitHexA.length; j++) {
                intA += Integer.parseInt(splitHexA[j], 16);
            }

            int afterNum = intA % b;

            if (afterNum < c) {
                Integer num = countMap.get(String.valueOf(afterNum));
                if (null == num) {
                    num = 1;
                } else {
                    num = num + 1;
                }
                countMap.put(String.valueOf(afterNum), num);
            }
        }

        int maxNum = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (maxNum < entry.getValue()) {
                maxNum = entry.getValue();
            }
        }

        System.out.println(maxNum);
    }

    private static String[] split1(String fourByteNum) {

        String[] byteData = new String[4];
        int i = 0;
        while (fourByteNum.length() >= 2) {
            byteData[i] = fourByteNum.substring(0, 2);
            fourByteNum = fourByteNum.substring(2);
            i++;
        }

        return byteData;
    }
}
