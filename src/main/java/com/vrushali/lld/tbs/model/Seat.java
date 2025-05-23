package com.vrushali.lld.tbs.model;

import java.util.Objects;

public class Seat {
    private final String id;
    private final SeatCategory category;
    private final double price;

    public Seat(String id, SeatCategory category, double price) {
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public SeatCategory getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Double.compare(seat.price, price) == 0 && Objects.equals(id, seat.id) && category == seat.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, price);
    }
}
