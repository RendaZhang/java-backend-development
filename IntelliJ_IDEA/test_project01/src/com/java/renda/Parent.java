package com.java.renda;

/**
 * @author Renda Zhang
 * @create 2020-04-14 18:17
 */
public abstract class Parent {
    int num = 1;

    public Parent() {
        System.out.println("Abstract Parent constructor executed.");
    }

    public abstract void eat();

    public int getNum() {
        return num;
    }

}
