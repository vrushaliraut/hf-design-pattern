package com.vrushali.hf.dp.abstraction;

public class Whale extends Animal implements Swimmable{
    public Whale(String name, String color) {
        super(name, color);
    }

    @Override
    void makeSound() {

    }

    @Override
    public void swim() {
        System.out.println("Whale can swim");
    }
}
