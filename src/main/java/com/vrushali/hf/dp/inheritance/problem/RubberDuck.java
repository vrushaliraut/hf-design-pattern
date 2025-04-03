package com.vrushali.hf.dp.inheritance.problem;

public class RubberDuck extends Duck {

    @Override
    public void display() {
        System.out.println("I am RubberDuck");
    }

    @Override
    public void quack() {
        System.out.println("Squeak");
    }

    @Override
    public void fly() {
        System.out.println("RubberDuck can't fly");
    }
}
