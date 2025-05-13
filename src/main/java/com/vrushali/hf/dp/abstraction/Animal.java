package com.vrushali.hf.dp.abstraction;

public abstract class Animal {
    String name;
    String color;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    abstract void makeSound();

    public void sleep() {
        System.out.println("sleeping");
    }
}
