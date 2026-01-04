package com.test;

// 請問大家可以幫我看為甚麼執行不出來東西嗎package HW;.
// 抽象類別.
public abstract class CShape {

    public int number; /* 邊數 */
    public int totalAngle; /* 內角和,公式為 totalAangle=(number-2)*180 */

    public abstract void angle(); /* 抽象方法 */

    @Override
    public abstract String toString();

}