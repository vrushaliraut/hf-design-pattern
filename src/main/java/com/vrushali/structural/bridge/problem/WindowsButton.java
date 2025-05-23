package com.vrushali.structural.bridge.problem;

public class WindowsButton extends ThemedButton {

    public WindowsButton(String label) {
        super(label);
    }

    @Override
    public void render() {
        System.out.println("Rendering button " + label + " with Windows Theme borders and style");
    }
}
