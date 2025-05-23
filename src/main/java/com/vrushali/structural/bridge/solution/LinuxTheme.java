package com.vrushali.structural.bridge.solution;

// --- ConcreteImplementor C: LinuxTheme ---
public class LinuxTheme implements ThemeImplementor{
    @Override
    public String drawButton(String label) {
        return "<Linux Button: '" + label + "' (GTK/Qt Flat Style)>";
    }

    @Override
    public String drawCheckbox(String label, boolean isChecked) {
        return "<Linux Checkbox: " + (isChecked ? "[*]" : "[_]") + " " + label + " (Simple Box)>";
    }
}
