package com.vrushali.hf.dp.inheritance.problem;

import java.util.Arrays;

public class SimUDuckApp {
    public static void main(String[] args) {

        // Create instances of each Duck subclass
        Duck mallard = new MallardDuck();
        Duck redHead = new RedHeadDuck();
        Duck rubber = new RubberDuck();
        Duck decoy = new DecoyDuck();

        for (Duck duck : Arrays.asList(mallard, redHead, rubber, decoy)) {
            duck.display();
            duck.swim();
        }
    }
}
