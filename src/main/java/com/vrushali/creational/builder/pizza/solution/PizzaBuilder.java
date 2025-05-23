package com.vrushali.creational.builder.pizza.solution;

public class PizzaBuilder {
    private String crust;
    private String sauce;
    private String cheese;
    private String pepperoni;
    private String mushrooms;
    private String onions;

    public String getCrust() {
        return crust;
    }

    public String getSauce() {
        return sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public String getPepperoni() {
        return pepperoni;
    }

    public String getMushrooms() {
        return mushrooms;
    }

    public String getOnions() {
        return onions;
    }

    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setCheese(String cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder setPepperoni(String pepperoni) {
        this.pepperoni = pepperoni;
        return this;
    }

    public PizzaBuilder setMushrooms(String mushrooms) {
        this.mushrooms = mushrooms;
        return this;
    }

    public PizzaBuilder setOnions(String onions) {
        this.onions = onions;
        return this;
    }

    public Pizza build(){
        return new Pizza(this);
    }


}
