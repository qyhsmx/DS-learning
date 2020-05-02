package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class Test {
//    public static void main(String[] args) {
//        test2();
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getTotalCount(sc.nextInt()));
    }
    public static int getTotalCount(int m)
    {
        if(m<3)return 1;
        int res = 0;
        int a = 1;
        int b = 1;
        for(int i=3;i<=m;i++)
        {
            res = a+b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void test(){
        LocalDate parse = LocalDate.parse("20201212", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);
        LocalDate parse1 = LocalDate.parse("2020-12-12",DateTimeFormatter.ISO_DATE);
        System.out.println(parse1);

        LocalDate.of(2002, Month.AUGUST, 12);

        int[] arr = new int[]{10,2,9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void test2(){
        HashMap map = new HashMap(21);
    }

    private static volatile int count = 0;

    private static synchronized void request()throws Exception{
        TimeUnit.MILLISECONDS.sleep(5);
        //while (!cas(getCount(),count+1)){};
        count++;
    }
    private static synchronized boolean cas(int expectVal,int newVal){
        if(expectVal==getCount()){
            count = newVal;
            return true;
        }
        return false;
    }

    public static void main66(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    try {
                        request();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("spend time -> "+(end-start));
        System.out.println("count is -> "+getCount());
    }

    public static int getCount() {
        return count;
    }

}
