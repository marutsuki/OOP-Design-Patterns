package gof.structural.facade.restaurantSystemPackage;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CardProviderApiAdaptorAlice implements CardProviderApiAdaptor {
    @Override
    public boolean charge(String card, double price) {
        log.info("Charging {} with ${}", card, price);
        return true;
    }
}
