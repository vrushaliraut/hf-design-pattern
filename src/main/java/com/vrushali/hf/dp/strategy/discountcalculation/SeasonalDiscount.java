package com.vrushali.hf.dp.strategy.discountcalculation;

public class SeasonalDiscount implements DiscountStrategy {
    private double seasonalRate;

    public SeasonalDiscount(double seasonalRate) {
        this.seasonalRate = seasonalRate;
    }

    @Override
    public double applyDiscount(ShoppingCart cart) {
        double total = cart.calculateTotal();
        return total * seasonalRate; // e.g., seasonalRate = 0.8 for 20% off
    }
}
