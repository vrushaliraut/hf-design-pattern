package com.vrushali.creational.builder.pizza.problem;

/*
* 1. Telescoping Constructors
  2. Hard to Read Object Creation
  3. Mutable Objects
 * */
public class PizzaClientProblem {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("thin");
        Pizza pizza2 = new Pizza("thick", "tomato");
        Pizza pizza3 = new Pizza("deep-dish", "marinara", "mozzarella", "pepperoni", "mushrooms");

        //  pizza.setPepperoni("yes");
        // Pizza is mutable The Pizza class has setters, making it mutable
        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);
    }
}
