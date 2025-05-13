package com.vrushali.hf.dp.simple.inheritance;

public class Vehicle {
    protected String make;
    private String model;
    private String color;

    public Vehicle(String make, String model, String color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public Vehicle() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected void start() {
        System.out.println("Vehicle is starting");
    }

    public void describe() {
        System.out.println("This vehicle is from the maker : " + this.make
                + "has model : " + this.model + " has color : " + this.color);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
