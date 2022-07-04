package com.jetbrains.sandbox;

public class Pricing {
    static final private int HIGHEST_ROW_FOR_PREMIUM = 4;
    static final private int PRICE_PREMIUM = 10;
    static final private int PRICE_CHEAP= 8;

    public static int setPrice(int row) {
        int price;
        if (row <= HIGHEST_ROW_FOR_PREMIUM) {
            price = PRICE_PREMIUM;
        } else {
            price = PRICE_CHEAP;
        }
        return price;
    }

}
