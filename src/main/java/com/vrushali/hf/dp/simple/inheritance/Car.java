package com.vrushali.hf.dp.simple.inheritance;

public class Car extends Vehicle {
    private String carType;

//    public Car(String make, String model, String color) {
//        super(make, model, color);
//    }


    public Car(String make, String model, String color, String carType) {
        super(make, model, color);
        this.carType = carType;
    }

    public Car(String carType) {
        this.carType = carType;
    }

    @Override
    public void describe() {
        System.out.println("This vehicle is from the maker : " + this.make
                + "has model : " + this.getModel() + "has color : " + this.getColor());
    }
}
