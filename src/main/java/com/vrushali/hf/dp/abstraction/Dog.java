package com.vrushali.hf.dp.abstraction;

public class Dog extends Animal{
    public Dog(String name, String color) {
        super(name, color);
    }

    @Override
    public void makeSound() {
        System.out.println("Making Dog Sound");
    }
}
