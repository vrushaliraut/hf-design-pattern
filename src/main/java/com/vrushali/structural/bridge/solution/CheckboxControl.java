package com.vrushali.structural.bridge.solution;

public class CheckboxControl extends Control {
    private boolean isChecked;

    public CheckboxControl(ThemeImplementor theme, String label) {
        super(theme, label);
    }

    @Override
    public String render() {
        // Delegates the drawing to the current theme implementor
        return theme.drawCheckbox(this.label, this.isChecked);
    }

    public void toggle() {
        this.isChecked = !this.isChecked;
        System.out.println("Checkbox '" + label + "' toggled to " + this.isChecked);
    }

    public boolean isChecked() {
        return isChecked;
    }

}
