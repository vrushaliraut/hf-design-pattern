package com.vrushali.creational.factorymethod.solution;

// Concrete Products
public class ButtonImpl implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a standard button");
    }

    @Override
    public void onClick() {
        System.out.println("Standard button clicked");
    }
}
