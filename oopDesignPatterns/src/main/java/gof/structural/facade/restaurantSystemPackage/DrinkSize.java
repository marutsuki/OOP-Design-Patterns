package gof.structural.facade.restaurantSystemPackage;

import lombok.Getter;

@Getter
public enum DrinkSize {
    SMALL(1),
    MEDIUM(1.5),
    LARGE(1.75);

    private double priceMultiplier;
    DrinkSize(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }
}
