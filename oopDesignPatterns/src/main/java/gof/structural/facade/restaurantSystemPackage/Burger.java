package gof.structural.facade.restaurantSystemPackage;

import java.util.List;

public class Burger implements Item {

    private static final double BASE_PRICE = 2;
    private List<Filling> fillings;
    @Override
    public double getPrice() {
        double finalPrice = BASE_PRICE;
        for (Filling f : fillings) {
            finalPrice += f.getPrice();
        }
        return finalPrice;
    }
}
