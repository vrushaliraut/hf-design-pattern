package com.vrushali.hf.dp.behaviour;

public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
