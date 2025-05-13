package com.vrushali.hf.dp.strategy.discountcalculation;

public class PercentageDiscount implements DiscountStrategy{

    private final double percentage; // e.g., 15 for 15%

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(ShoppingCart shoppingcart) {
        double total = shoppingcart.calculateTotal();
        return total - (total * percentage / 100);
    }
}
