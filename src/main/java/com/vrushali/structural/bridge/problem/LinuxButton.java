package com.vrushali.structural.bridge.problem;

public class LinuxButton extends ThemedButton{
    public LinuxButton(String label) {
        super(label);
    }

    @Override
    public void render() {
        System.out.println("Rendering Button "+label+"with Linux GTK theme appearance");
    }
}
