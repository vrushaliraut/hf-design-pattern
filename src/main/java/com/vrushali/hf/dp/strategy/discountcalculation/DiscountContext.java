package com.vrushali.hf.dp.strategy.discountcalculation;

public class DiscountContext {
    DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double checkout(ShoppingCart cart) {
        return discountStrategy.applyDiscount(cart);
    }
}
