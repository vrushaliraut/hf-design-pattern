package com.vrushali.hf.dp.strategy.discountcalculation;

public class FlatDiscount implements DiscountStrategy {

    private final double amount;

    public FlatDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(ShoppingCart shoppingcart) {
        double total = shoppingcart.calculateTotal();
        return Math.max(0,total - amount);
    }
}
