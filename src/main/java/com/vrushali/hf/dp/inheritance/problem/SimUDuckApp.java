package com.vrushali.hf.dp.inheritance.problem;

public class SimUDuckApp {
    public static void main(String[] args) {

        // Create instances of each Duck subclass
        Duck mallard = new MallardDuck();
        Duck redHead = new RedHeadDuck();
        Duck rubber = new RubberDuck();
        Duck decoy = new DecoyDuck();

        // Test each duck
        System.out.println("=== Mallard Duck ===");
        mallard.display();
        mallard.quack();
        mallard.swim();
        mallard.fly();


        System.out.println("\n=== ReadHead Duck ===");
        redHead.display();
        redHead.quack();
        redHead.swim();
        redHead.fly();


        System.out.println("\n=== Rubber Duck ===");
        rubber.display();
        rubber.quack();
        rubber.swim();
        rubber.fly();

        System.out.println("\n=== Decoy Duck ===");
        decoy.display();
        decoy.quack(); // No output
        decoy.swim();
        decoy.fly();
    }
}
