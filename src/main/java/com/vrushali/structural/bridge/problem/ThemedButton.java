package com.vrushali.structural.bridge.problem;

public abstract class ThemedButton {
    protected String label;

    public ThemedButton(String label) {
        this.label = label;
    }

    public void onCLick() {
        System.out.println("Button" + label + "clicked");
    }

    public abstract void render();  // Rendering theme dependent
}
