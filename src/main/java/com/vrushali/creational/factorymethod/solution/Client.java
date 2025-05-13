package com.vrushali.creational.factorymethod.solution;

public class Client {
    public static void main(String[] args) {
        UIFramework fancyUIFramework = new FancyUIFramework();
        fancyUIFramework.render(); // Renders FancyButton

        UIFramework standardFramework = new StandardUIFramework();
        standardFramework.render(); // Renders a ButtonImpl
    }
}
