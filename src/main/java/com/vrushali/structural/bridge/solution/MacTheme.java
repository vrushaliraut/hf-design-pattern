package com.vrushali.structural.bridge.solution;

// ----- ConcreteImplementor B: MacTheme -----
public class MacTheme implements ThemeImplementor {

    @Override
    public String drawButton(String label) {
        return "{MacOS Button: '" + label + "' (Rounded, Aqua Gloss)}";
    }

    @Override
    public String drawCheckbox(String label, boolean isChecked) {
        return "{MacOS Checkbox: " + (isChecked ? "(\u2713)" : "( )") + " " + label + " (Smooth Circle)}";
    }
}
