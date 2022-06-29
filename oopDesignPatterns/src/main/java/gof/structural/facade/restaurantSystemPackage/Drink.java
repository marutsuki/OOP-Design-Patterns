package gof.structural.facade.restaurantSystemPackage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Drink implements Item {
    private DrinkType drinkType;
    private DrinkSize drinkSize;

    @Override
    public double getPrice() {
        return drinkSize.getPriceMultiplier() * drinkType.getPrice();
    }
}
