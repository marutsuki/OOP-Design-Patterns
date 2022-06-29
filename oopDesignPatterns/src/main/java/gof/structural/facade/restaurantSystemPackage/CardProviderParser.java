package gof.structural.facade.restaurantSystemPackage;

public class CardProviderParser {
    private static CardProviderParser instance;
    private CardProviderParser() {}

    public static CardProviderParser getInstance() {
        if (instance == null) {
            instance = new CardProviderParser();
        }
        return instance;
    }

    public CardProviderApiAdaptor getProviderApiAdaptor() {
        // For example sake, we just return one adaptor with no further logic
        return new CardProviderApiAdaptorAlice();
    }
}
