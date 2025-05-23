package com.vrushali.structural.bridge.solution;

// ------ ConcreteImplementor A: WindowsTheme ----
public class WindowsTheme implements ThemeImplementor {
    @Override
    public String drawButton(String label) {
        return "[Windows Button: '" + label + "' (Square Edges, Aero Style)]";
    }

    @Override
    public String drawCheckbox(String label, boolean isChecked) {
        return "[Windows Checkbox: " + (isChecked ? "[X]" : "[ ]") + " " + label + " (Classic Square)]";
    }
}
