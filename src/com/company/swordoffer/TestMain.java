package com.company.swordoffer;

import java.math.BigDecimal;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class TestMain {


    public static void main1(String[] args) {
        double a = 0.0;
        double sum = 1.0;
        float value = new BigDecimal(a/sum*100).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        System.out.println(value);
    }

    public static void main(String[] args) {

        System.out.println();
    }
    //快速求正整数次幂
    private static void getPow(int base, int n){
        int pow = 1;
        while (n>0){
            if((n&1)==1){
                pow*=base;
            }
            base*=base;
            n=n>>1;
        }
        System.out.println("pow is "+pow);
    }
}
