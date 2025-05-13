package com.vrushali.hf.dp.behaviour;

public class ModelDuck extends Duck {

    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public ModelDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
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
        System.out.println("I'a a ModelDuck");
    }
}
