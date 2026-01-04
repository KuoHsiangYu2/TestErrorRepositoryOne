package com.test;

public class CRect extends CShape {

    // 抽象方法.
    @Override
    public void angle() {
        totalAngle = (4 - 2) * 180;
    }

    @Override
    public String toString() {
        return "正四邊形的每一角為" + (totalAngle / 4);
    }
}