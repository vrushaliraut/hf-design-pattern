package com.vrushali.hf.dp.inheritance.solution;

public class SimUDuckApp {
    public static void main(String[] args) {
        System.out.println("=== Mallard Duck ===");
        Duck mallard = new MallardDuck();

        testDuck(mallard);

        System.out.println("\n === RedHeadDuck Duck ===");
        Duck redHeadDuck = new RedHeadDuck();
        testDuck(redHeadDuck);

        System.out.println("\n === RubberDuck Duck ===");
        Duck rubberDuck = new RubberDuck();
        testDuck(rubberDuck);

        System.out.println("\n === DecoyDuck Duck ===");
        Duck decoyDuck = new DecoyDuck();
        testDuck(decoyDuck);

    }

    private static void testDuck(Duck duck) {
        duck.display();
        duck.swim();

        if (duck instanceof Flyable) {
            ((Flyable) duck).fly();
        }

        if (duck instanceof Quackable) {
            ((Quackable) duck).quack();
        }
    }
}
