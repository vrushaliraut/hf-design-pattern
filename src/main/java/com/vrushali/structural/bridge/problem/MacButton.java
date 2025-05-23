package com.vrushali.structural.bridge.problem;

public class MacButton extends ThemedButton {

    public MacButton(String label) {
        super(label);
    }

    @Override
    public void render() {
        System.out.println("Rendering Button " + label + "with macOD Aqua Theme gloss and shadow");
    }
}
