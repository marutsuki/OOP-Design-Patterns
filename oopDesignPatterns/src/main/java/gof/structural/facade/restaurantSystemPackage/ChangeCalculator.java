package gof.structural.facade.restaurantSystemPackage;

public class ChangeCalculator {
    private static ChangeCalculator instance;
    private ChangeCalculator() {}

    public static ChangeCalculator getInstance() {
        if (instance == null) {
            instance = new ChangeCalculator();
        }
        return instance;
    }

    /**
     * This is obviously a trivial calculation, but we are just using it
     * as example
     */
    public double calculateChange(double paid, double price) {
        if (price > paid) {
            throw new RuntimeException("Not enough money paid");
        }
        return paid - price;
    }
}
