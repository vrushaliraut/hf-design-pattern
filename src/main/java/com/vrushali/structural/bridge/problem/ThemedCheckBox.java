package com.vrushali.structural.bridge.problem;

public abstract class ThemedCheckBox {
    protected String label;
    public boolean isChecked;

    public ThemedCheckBox(String label) {
        this.label = label;
    }

    public void toggele() {
        isChecked = !isChecked;
        System.out.println("Checkbox " + label + " toggled to " + isChecked);
    }

    public abstract void render();
}
