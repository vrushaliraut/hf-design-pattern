package com.vrushali.structural.bridge.problem;

public class MacCheckbox extends  ThemedCheckBox{
    public MacCheckbox(String label) {
        super(label);
    }

    @Override
    public void render() {
        System.out.println("Rendering Checkbox '" + label + "' with macOS Aqua Theme round tick.");
    }
}
