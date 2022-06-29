package gof.structural.facade.restaurantSystemPackage;

import lombok.Getter;

@Getter
public enum Filling {
    SALAD(0.25),
    TOMATO(0.5),
    TOMATO_SAUCE(0.1),
    PATTY(2),
    PICKLES(1),
    MUSTARD(0.2),
    ONION(0.5);

    private double price;
    Filling(double price) {
        this.price = price;
    }
}
