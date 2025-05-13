package com.vrushali.hf.dp.abstraction;

public class Monkey extends Animal{
    public Monkey(String name, String color) {
        super(name, color);
    }

    @Override
    void makeSound() {
        System.out.println("Making Monkey Sound");
    }
}
