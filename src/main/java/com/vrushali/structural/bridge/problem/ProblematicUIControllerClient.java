package com.vrushali.structural.bridge.problem;

public class ProblematicUIControllerClient {
    public static void main(String[] args) {
        System.out.println("----- Problematic UI controller rendering-------");
        ThemedButton winButton = new WindowsButton("Submit");
        winButton.render();
        winButton.onCLick();

        ThemedCheckBox macCheck = new MacCheckbox("Agree to Terms");
        macCheck.render();
        macCheck.toggele();


    }
}
