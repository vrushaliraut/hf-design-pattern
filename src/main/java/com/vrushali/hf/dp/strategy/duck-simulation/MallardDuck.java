package com.vrushali.hf.dp.behaviour;

public class MallardDuck extends Duck {
    QuackBehaviour quackBehaviour;
    FlyBehaviour flyBehaviour;

    public MallardDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    public void performFly() {
        flyBehaviour.fly();
    }

    @Override
    public void performQuack() {
        quackBehaviour.quack();
    }

    @Override
    public void display() {
        System.out.println("I am a MallardDuck");
    }
}
