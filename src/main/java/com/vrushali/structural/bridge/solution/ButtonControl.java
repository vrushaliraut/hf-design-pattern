package com.vrushali.structural.bridge.solution;

// --- RefinedAbstraction A: ButtonControl ---
public class ButtonControl extends Control {

    public ButtonControl(String label, ThemeImplementor theme) {
        super(theme, label);
    }

    @Override
    public String render() {
        // Delegates the drawing to the current theme implementor
        return theme.drawButton(this.label);
    }

    // Button- specific behaviour can be added here
    public void submit() {
        System.out.println("Button '" + label + "' submitted data.");
    }
}
