package com.vrushali.creational.factorymethod.solution;

public abstract class UIFramework {
    public abstract Button createButton(); // factory method

    public void render() {
        Button button = createButton(); // Uses the Factory Method
        button.onClick();
        button.render();
    }
}

class FancyUIFramework extends UIFramework {

    @Override
    public Button createButton() {
        return new FancyButton();
    }
}

class StandardUIFramework extends UIFramework {
    @Override
    public Button createButton() {
        return new ButtonImpl();
    }
}
