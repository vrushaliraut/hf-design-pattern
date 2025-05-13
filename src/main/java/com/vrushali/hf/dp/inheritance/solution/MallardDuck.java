package com.vrushali.hf.dp.inheritance.solution;

public class MallardDuck extends Duck implements Flyable, Quackable {

    @Override
    public void display() {
        System.out.println("I am a MallardDuck : ");
    }

    @Override
    public void fly() {
        System.out.println("MallardDuck can fly");
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck make sound quack quack");
    }
}
