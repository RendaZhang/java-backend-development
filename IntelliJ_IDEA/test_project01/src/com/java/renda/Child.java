package com.java.renda;

/**
 * @author Renda Zhang
 * @create 2020-04-14 18:22
 */
public class Child extends Parent {
    int num = 2;

    public Child() {
        System.out.println("Child Constructor operated.");
    }

    @Override
    public void eat() {
        System.out.println("Have Dinner!");
    }

    public int getNum() {
        return num;
    }

}
