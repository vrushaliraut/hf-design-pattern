package com.vrushali.structural.bridge.solution;

// ------ Implementor Interface: ThemeImplementor ---
public interface ThemeImplementor {
    String drawButton(String label);

    String drawCheckbox(String label, boolean isChecked);

    // Could have more methods like drawFrame, drawText
}
