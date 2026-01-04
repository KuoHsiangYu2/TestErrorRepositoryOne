package com.test;

public class MainClass {

    public static void main(String[] args) {

        CShape[] c = new CShape[3];
        c[0] = new CTriangle();
        c[1] = new CRect();
        c[2] = new CPentagon();

        c[0].angle();
        System.out.println(c[0]);

        c[1].angle();
        System.out.println(c[1].toString());

        c[2].angle();
        System.out.println(c[2].toString());

        System.out.println("finish");
    }
}
