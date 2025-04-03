package com.vrushali.hf.dp.inheritance.problem;

public abstract class Duck {
    public void quack() {
        System.out.println("Duck make sound");
    }

    public void swim() {
        System.out.println("Duck can swim");
    }

    abstract void fly();

    abstract void display();
}
