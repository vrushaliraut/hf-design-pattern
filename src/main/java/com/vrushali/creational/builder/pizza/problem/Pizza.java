package com.vrushali.creational.builder.pizza.problem;

public class Pizza {
    private String crust;
    private String sauce;
    private String cheese;
    private String pepperoni;
    private String mushrooms;
    private String onions;

    public Pizza(String crust) {
        this.crust = crust;
    }

    public Pizza(String crust, String sauce) {
        this.crust = crust;
        this.sauce = sauce;
    }

    public Pizza(String crust, String sauce, String cheese) {
        this(crust, sauce);
        this.cheese = cheese;
    }

    public Pizza(String crust, String sauce, String cheese, String pepperoni) {
        this(crust, sauce, cheese);
        this.pepperoni = pepperoni;
    }

    public Pizza(String crust, String sauce, String cheese, String pepperoni, String mushrooms) {
        this(crust, sauce, cheese, pepperoni);
        this.mushrooms = mushrooms;
    }

    public Pizza(String crust, String sauce, String cheese, String pepperoni, String mushrooms, String onions) {
        this(crust, sauce, cheese, pepperoni, mushrooms);
        this.onions = onions;
    }

    // Getters

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
