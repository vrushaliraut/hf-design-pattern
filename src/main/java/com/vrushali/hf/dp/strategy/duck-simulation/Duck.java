package com.vrushali.hf.dp.behaviour;

public abstract class Duck {
    com.vrushali.hf.dp.behaviour.FlyBehaviour flyBehaviour;
    com.vrushali.hf.dp.behaviour.QuackBehaviour quackBehaviour;

    public void swim(){
        System.out.println("All ducks float even decoys");
    }

    public void performFly(){
        flyBehaviour.fly();  // Delegate fly behaviour
    }

    public void performQuack(){
        quackBehaviour.quack(); // Delegate quack behaviour
    }

    // change flying or quacking behaviour at runTime
    public void setFlyBehaviour(com.vrushali.hf.dp.behaviour.FlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(com.vrushali.hf.dp.behaviour.QuackBehaviour quackBehaviour){
        this.quackBehaviour = quackBehaviour;
    }

    public abstract void display(); // Display subclass specific
}
