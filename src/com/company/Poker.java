package com.company;

import java.util.*;

/**
 * @author qyhsmx@outlook.com
 * @date
 * 牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
 * 牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
 * 牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
 * 牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
 * 牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
 * 牌型6，三条：三张相同 + 两张单。
 */
public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            list.add(string);
            if (list.size() == 5) {
                int r = getCard(list);
                System.out.println(r);
                list.clear();
            }
        }
    }

    private static int getCard(List<String> list) {
        int temp = 7;
        int size = list.size();
        List<String> numList = new ArrayList<>();
        Set<String> numSet = new TreeSet<>();
        List<String> colourList = new ArrayList<>();
        Set<String> colourSet = new TreeSet<>();
        for (String s : list) {
            String num = s.split(" ")[0];
            String colour = s.split(" ")[1];
            if (num.equals("J")) {
                numList.add("11");
                numSet.add("11");
            } else if (num.equals("Q")) {
                numList.add("12");
                numSet.add("12");
            } else if (num.equals("K")) {
                numList.add("13");
                numSet.add("13");
            } else if (num.equals("A")) {
                numList.add("14");
                numSet.add("14");
            } else {
                numList.add(num);
                numSet.add(num);
            }
            colourList.add(colour);
            colourSet.add(colour);
        }
        // 同花顺,或者同花
        if (colourSet.size() == 1) {
            Collections.sort(numList);
            for (int i = 0; i < numList.size() - 1; i++) {
                if (Integer.parseInt(numList.get(i + 1)) - Integer.parseInt(numList.get(i)) == 1) {
                    if (i == numList.size() - 2) {
                        temp = 1;
                    }
                } else {
                    if (temp > 4) {
                        temp = 4;
                    }
                }
            }
        }
        // 四条或者葫芦
        if (numSet.size() == 2) {
            Collections.sort(numList);
            // 四条
            if (!numList.get(0).equals(numList.get(1)) || !numList.get(size - 1).equals(numList.get(size - 2))) {
                if (temp > 2) {
                    temp = 2;
                }
            } else {
                if (temp > 3) {
                    temp = 3;
                }
            }
        }
        // 三条
        if (numSet.size() == 3) {
            if (temp > 6) {
                temp = 6;
            }
        }
        // 顺子
        if (colourSet.size() > 1) {
            Collections.sort(numList);
            for (int i = 0; i < numList.size() - 1; i++) {
                if (Integer.parseInt(numList.get(i + 1)) - Integer.parseInt(numList.get(i)) == 1) {
                    if (i == numList.size() - 2) {
                        if(temp>5){
                            temp = 5;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return temp;
    }
}
