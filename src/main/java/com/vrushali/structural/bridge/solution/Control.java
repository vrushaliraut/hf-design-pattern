package com.vrushali.structural.bridge.solution;

// --- Abstraction: Control ---
public abstract class Control {
    // This is the BRIDGE: a reference to the Implementor interface
    protected ThemeImplementor theme;
    protected String label;

    public Control(ThemeImplementor theme, String label) {
        this.theme = theme;
        this.label = label; // Injected at construction
    }

    // Abstract method to be implemented by RefinedAbstractions, using the theme
    public abstract String render();

    // Common control behavior (could be more complex)
    public void onClick() {
        System.out.println("Control '" + label + "' was clicked (generic action).");

    }

    // Allow changing the theme at runtime
    public void setTheme(ThemeImplementor theme) {
        System.out.println("Control '" + label + "' changing theme to " + theme.getClass().getSimpleName());
        this.theme = theme;
    }
}
