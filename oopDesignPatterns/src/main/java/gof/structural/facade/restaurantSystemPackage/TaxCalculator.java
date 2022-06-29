package gof.structural.facade.restaurantSystemPackage;

public class TaxCalculator {

    private static TaxCalculator instance;
    private TaxCalculator() {}

    public static TaxCalculator getInstance() {
        if (instance == null) {
            instance = new TaxCalculator();
        }
        return instance;
    }

    public double calculate(double price, PaymentType paymentType) {
        return price * paymentType.getTaxMultiplier();
    }
}
