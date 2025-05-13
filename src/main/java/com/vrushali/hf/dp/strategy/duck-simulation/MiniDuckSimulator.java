package com.vrushali.hf.dp.behaviour;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();

        // These methods call the behaviour objects
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();

        // Initial behaviour
        model.performFly();
        model.performQuack();

        // change behaviour dynamically
        model.setFlyBehaviour(new FlyRocketPowered());
        model.performFly();
    }
}
