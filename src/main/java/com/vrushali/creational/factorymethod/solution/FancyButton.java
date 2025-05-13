package com.vrushali.creational.factorymethod.solution;

public class FancyButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a fancy button");
    }

    @Override
    public void onClick() {
        System.out.println("Fancy button clicked");
    }
}
