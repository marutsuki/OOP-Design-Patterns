package gof.structural.facade.restaurantSystemPackage;

import java.util.List;

public class FeeCalculator {

    private static FeeCalculator instance;
    private FeeCalculator() {}

    public static FeeCalculator getInstance() {
        if (instance == null) {
            instance = new FeeCalculator();
        }
        return instance;
    }
    public double calculate(List<Item> order) {
        double fee = 0;
        for (Item i : order) {
            fee += i.getPrice();
        }
        return fee;
    }
}
