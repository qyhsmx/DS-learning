package com.company;


import java.util.Scanner;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class TouziTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Touzi touzi = new Touzi();
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            for (char c:chars){
                switch (c){
                    case 'L':
                        touzi.turnLeft();
                        break;
                    case 'R':
                        touzi.turnRight();
                        break;
                    case 'F':
                        touzi.turnFront();
                        break;
                    case 'B':
                        touzi.turnBack();
                        break;
                    case 'A':
                        touzi.turnAntiClockWise90();
                        break;
                    case 'C':
                        touzi.turnClockWise90();
                        break;
                }
            }
            System.out.println(touzi);
            touzi.init();
        }
    }


}
