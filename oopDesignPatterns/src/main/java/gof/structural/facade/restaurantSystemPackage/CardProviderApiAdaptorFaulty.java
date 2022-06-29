package gof.structural.facade.restaurantSystemPackage;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CardProviderApiAdaptorFaulty implements CardProviderApiAdaptor {
    @Override
    public boolean charge(String card, double price) {
        log.info("Charging {} with ${}", card, price);
        return Math.random() < 0.5;
    }
}
