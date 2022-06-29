package gof.structural.facade;

import gof.structural.facade.restaurantSystemPackage.*;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class RestaurantSystemFacade {

    private List<Item> order = new ArrayList<>();

    public RestaurantSystemFacade createOrder() {
        order = new ArrayList<>();
        return this;
    }

    public RestaurantSystemFacade addItem(Item item) {
        order.add(item);
        return this;
    }

    public boolean chargeOrder(double payment, PaymentType paymentType, String card) {
        double price = FeeCalculator.getInstance().calculate(order);
        price += TaxCalculator.getInstance().calculate(price, paymentType);

        if (paymentType.equals(PaymentType.CASH)) {
            try {
                double change = ChangeCalculator.getInstance().calculateChange(payment, price);
                log.info("Change: {}", change);
            } catch (RuntimeException e) {
                log.info("Failed to charge order");
                return false;
            }
        } else if (paymentType.equals(PaymentType.CARD)) {
            CardProviderApiAdaptor cardProviderApi = CardProviderParser.getInstance().getProviderApiAdaptor();
            if (!cardProviderApi.charge(card, price)) {
                log.info("Failed to charge order");
                return false;
            }
        }
        return true;
    }
}
