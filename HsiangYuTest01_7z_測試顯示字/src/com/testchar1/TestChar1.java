package com.testchar1;

public class TestChar1 {

    public static void main(String[] args) {
        // Java程式碼.

        StringBuilder sb = new StringBuilder();
        String inputStr = sb
                .append("黑白之網！\n")
                .append("二十二個橋梁，\n")
                .append("六十六個冠帶，\n")
                .append("足跡 遠雷 尖峰 回地 夜伏 雲海 蒼藍序列 充滿太圓，\n")
                .append("直奔天上！\n")
                .append("縛道之七十七『天挺空羅』！\n")
                .toString();
        char[] charArr = inputStr.toCharArray();
        for (int i = 0; i < charArr.length; ++i) {
            System.out.print(charArr[i]);
            try {
                /* 1000毫秒 = 1秒 */
                Thread.sleep(300); /* 300毫秒 = 0.3秒 */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%n");
    }

}
