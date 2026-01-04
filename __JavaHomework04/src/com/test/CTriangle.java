package com.test;

public class CTriangle extends CShape {

    // 抽象方法.
    @Override
    public void angle() {
        totalAngle = (3 - 2) * 180;
    }

    @Override
    public String toString() {
        return "正三邊形的每一角為" + (totalAngle / 3);
    }

}