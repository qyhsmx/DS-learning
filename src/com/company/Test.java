package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        LocalDate parse = LocalDate.parse("20201212", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);
        LocalDate parse1 = LocalDate.parse("2020-12-12",DateTimeFormatter.ISO_DATE);
        System.out.println(parse1);

        LocalDate.of(2002, Month.AUGUST, 12);
    }

    public void test2(){

    }

}
