package com.vrushali.hf.dp.strategy.discountcalculation;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems(){
        return items;
    }

    public double calculateTotal(){
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
