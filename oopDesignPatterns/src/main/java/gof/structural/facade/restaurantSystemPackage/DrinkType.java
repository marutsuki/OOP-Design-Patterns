package gof.structural.facade.restaurantSystemPackage;

import lombok.Getter;

@Getter
public enum DrinkType {
    COLA(1),
    LEMONADE(1.5),
    ORANGE(2);

    private double price;
    DrinkType(double price) {
        this.price = price;
    }
}
