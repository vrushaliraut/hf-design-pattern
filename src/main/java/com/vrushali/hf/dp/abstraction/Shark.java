package com.vrushali.hf.dp.abstraction;

public class Shark extends Animal implements Swimmable{
    public Shark(String name, String color) {
        super(name, color);
    }

    @Override
    void makeSound() {
        System.out.println("Making Shark Sound");
    }

    @Override
    public void swim() {
        System.out.println("Shark can swim");
    }
}
