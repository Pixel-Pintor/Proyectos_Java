package com.jetbrains.sandbox;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Seat {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean available;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = Pricing.setPrice(this.row);
        this.available = true;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    Seat() {}

    @Override
    public String toString() {
        return "{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }
}