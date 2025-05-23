package com.vrushali.structural.bridge.problem;

public class WindowsCheckbox extends ThemedCheckBox {
    public WindowsCheckbox(String label) {
        super(label);
    }

    @Override
    public void render() {
        System.out.println("Rendering Checkbox" + label + "with Windows Theme square box");
    }
}
