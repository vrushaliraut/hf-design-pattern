package com.vrushali.hf.dp.inheritance.problem;

public class DecoyDuck extends Duck {
    @Override
    public void fly() {
        System.out.println("DecoyDuck can't fly");
    }

    @Override
    public void display() {
        System.out.println("I am DecoyDuck");
    }
}
