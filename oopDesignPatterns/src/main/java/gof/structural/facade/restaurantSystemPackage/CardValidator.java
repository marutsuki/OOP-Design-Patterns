package gof.structural.facade.restaurantSystemPackage;

public class CardValidator {
    private static CardValidator instance;
    private CardValidator() {}

    public static CardValidator getInstance() {
        if (instance == null) {
            instance = new CardValidator();
        }
        return instance;
    }

    public boolean validate(String cardNumber) {
        // Looks up card through the provider's API

        // For example sake, we just say it works if its not null.
        return cardNumber != null;
    }
}
