package com.vrushali.hf.dp.inheritance.solution;

public class RedHeadDuck extends Duck implements Flyable, Quackable {
    @Override
    public void fly() {
        System.out.println("RedHeadDuck can fly");
    }

    @Override
    public void display() {
        System.out.println("I am a RedHeadDuck");
    }

    @Override
    public void quack() {
        System.out.println("RedHeadDuck make sound quack quack");
    }
}
