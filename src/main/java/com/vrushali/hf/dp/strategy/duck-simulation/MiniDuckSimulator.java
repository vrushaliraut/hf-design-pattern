package com.vrushali.hf.dp.behaviour;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        com.vrushali.hf.dp.behaviour.Duck mallard = new com.vrushali.hf.dp.behaviour.MallardDuck();

        // These methods call the behaviour objects
        mallard.performFly();
        mallard.performQuack();

        com.vrushali.hf.dp.behaviour.Duck model = new com.vrushali.hf.dp.behaviour.ModelDuck();

        // Initial behaviour
        model.performFly();
        model.performQuack();

        // change behaviour dynamically
        model.setFlyBehaviour(new com.vrushali.hf.dp.behaviour.FlyRocketPowered());
        model.performFly();
    }
}
