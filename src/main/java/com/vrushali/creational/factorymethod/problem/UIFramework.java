package com.vrushali.creational.factorymethod.problem;

// Tight Coupling
public class UIFramework {
    public Button createButton() {// directly create concrete button
        return new Button();
    }

    public void render() {
        Button button = createButton();
        button.onClick();
        button.render();
    }

}
