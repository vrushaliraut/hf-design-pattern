package com.vrushali.structural.bridge.solution;

// --- Client Code ---
public class UIControlBridgeClient {
    public static void main(String[] args) {
        System.out.println("--- UI Control Rendering with Bridge Pattern ---");
        // Create theme implementations
        ThemeImplementor windowsTheme = new WindowsTheme();
        ThemeImplementor macTheme = new MacTheme();
        ThemeImplementor linuxTheme = new LinuxTheme();

        // Create a Button with Windows theme
        Control submitButton = new ButtonControl("Submit", windowsTheme);
        System.out.println(submitButton.render());
        submitButton.onClick();
        ((ButtonControl) submitButton).submit(); // Button specific action

        System.out.println();

        // Create a Checkbox with Mac theme
        CheckboxControl termsCheckbox = new CheckboxControl(macTheme, "Agree to Terms");
        System.out.println(termsCheckbox.render());
        termsCheckbox.toggle();
        System.out.println("Checkbox checked: " + termsCheckbox.isChecked());

        System.out.println();

        // Create another Button, this time with Linux theme
        Control cancelButton = new ButtonControl("Cancel", linuxTheme);
        System.out.println(cancelButton.render());

        System.out.println();


        // Runtime theme switching for the cancel button
        cancelButton.setTheme(windowsTheme);
        System.out.println("Cancel button with new theme: " + cancelButton.render());


    }
}
