package com.test;

public class CPentagon extends CShape {

    // 抽象方法.
    @Override
    public void angle() {
        totalAngle = (5 - 2) * 180;
    }

    @Override
    public String toString() {
        return "正五邊形的每一角為" + (totalAngle / 5);
    }
}
