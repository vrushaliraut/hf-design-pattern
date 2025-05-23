package com.vrushali.creational.builder.pizza.solution;

public class PizzaClientSolution {
    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        Pizza pizza = pizzaBuilder.setCrust("this")
                .setOnions("red")
                .setCheese("cheeze")
                .setMushrooms("red mushroom").build();

        System.out.println(pizza);
    }
}
