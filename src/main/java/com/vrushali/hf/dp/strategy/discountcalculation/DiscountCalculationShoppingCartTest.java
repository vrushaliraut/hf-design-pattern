package com.vrushali.hf.dp.strategy.discountcalculation;

public class DiscountCalculationShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Shoes", 100));
        cart.addItem(new Item("Jacket", 200));

        DiscountContext context = new DiscountContext();

        // Flat $50 discount
        context.setDiscountStrategy(new FlatDiscount(50));
        System.out.println("Flat Discount: $" + context.checkout(cart));

        // 10% off
        context.setDiscountStrategy(new PercentageDiscount(10));
        System.out.println("10% Percentage Discount: $" + context.checkout(cart));

        // Seasonal 25% off
        context.setDiscountStrategy(new SeasonalDiscount(0.75)); // 25% off
        System.out.println("Seasonal Discount (25% off): $" + context.checkout(cart));
    }
}
