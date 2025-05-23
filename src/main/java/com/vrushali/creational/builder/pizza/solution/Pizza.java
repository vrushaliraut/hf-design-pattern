package com.vrushali.creational.builder.pizza.solution;

public class Pizza {
    private String crust;
    private String sauce;
    private String cheese;
    private String pepperoni;
    private String mushrooms;
    private String onions;

    public Pizza(PizzaBuilder builder) {
        this.crust = builder.getCrust();
        this.sauce = builder.getSauce();
        this.cheese = builder.getCheese();
        this.pepperoni = builder.getPepperoni();
        this.mushrooms = builder.getMushrooms();
        this.onions = builder.getOnions();
    }

    //Getters
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


    @Override
    public String toString() {
        return "Pizza{" +
                "crust='" + crust + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cheese='" + cheese + '\'' +
                ", pepperoni='" + pepperoni + '\'' +
                ", mushrooms='" + mushrooms + '\'' +
                ", onions='" + onions + '\'' +
                '}';
    }
}
