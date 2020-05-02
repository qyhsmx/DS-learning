package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class Majon {
    static final String duizi = "[1][1]|[2][2]|[3][3]|[4][4]|[5][5]|[6][6]|[7][7]|[8][8]|[9][9]";
    static final String shunzi = "[9][8][7]|[8][7][6]|[7][6][5]|[6][5][4]|[5][4][3]|[4][3][2]|[3][2][1]";
    static final String kezi = "[1]{3}|[2]{3}|[3]{3}|[4]{3}|[5]{3}|[6]{3}|[7]{3}|[8]{3}|[9]{3}";

    public static void main(String[] args) {
        Majon mahjong = new Majon();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            int len = input.length();
            if (len > 15 || len < 1 || !input.matches("^[1-9]{1,15}$")) {
                System.out.println("输入数据有误,no");
                continue;
            }
            // 可以和牌的输入数据长度只有2/5/8/11/14
            if (len == 2 || len == 5 || len == 8 || len == 11 || len == 14) {
                String reverse = new StringBuilder(input).reverse().toString();
                System.out.println(mahjong.judge(reverse) ? "yes" : "no");
            } else {
                System.out.println("输入数据长度无法胡牌,no");
            }
        }
        scanner.close();
    }

    /**
     * 判断是否可以和牌,输入数据已经过校验且被反转
     *
     * @param data
     * @return
     */
    public boolean judge(String data) {
        System.out.println(data);
        if (data.length() == 0) {
            return true;
        } else { // 判断输入是否有对子/刻子/顺子,若有则移除
            boolean hasDuizi = hasDuizi(data);
            boolean hasShunzi = hasShunzi(data);
            boolean hasKezi = hasKezi(data);

            if (hasDuizi) { // 有对子
                if (hasShunzi) { // 有顺子
                    if (hasKezi) { // 有刻子--->三种都有
                        String middle = data.replaceAll(shunzi, "");
                        return judge(middle);
                    } else { // 没有刻子--->只有对子和顺子
                        String middle = data.replaceAll(duizi, "");
                        return judge(middle);
                    }
                } else { // 没有顺子
                    // 1.有刻子--->只有对子和刻子eg:45556/22266 2.没有刻子--->只有对子
                    String middle = data.replaceAll(duizi, "");
                    return judge(middle);
                }
            } else { // 没有对子
                if (hasShunzi) { // 有顺子
                    // 1.有刻子--->只有顺子和刻子 2.没有刻子--->只有顺子
                    String middle = data.replaceAll(shunzi, "");
                    return judge(middle);
                } else { // 没有顺子
                    if (hasKezi) { // 有刻子--->只有刻子
                        String middle = data.replaceAll(kezi, "");
                        return judge(middle);
                    } else { // 没有刻子--->三种都没有
                        return false;
                    }
                }
            }
        }
    }

    public boolean hasDuizi(String data) {
        return Pattern.compile(duizi).matcher(data).find();
    }

    public boolean hasShunzi(String data) {
        return Pattern.compile(shunzi).matcher(data).find();
    }

    public boolean hasKezi(String data) {
        return Pattern.compile(kezi).matcher(data).find();
    }

}
