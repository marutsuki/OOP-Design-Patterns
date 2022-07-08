package gof.structural.adapter.thirdparty;

import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@Log4j2
public class BuyHomesDotComClient {

    public void rentProperty(long propertyId, Customer customer) {
        log.info("Renting property id: {} for customer {}", propertyId, customer.getId());
    }

    public void cancelRent(long propertyId, Customer customer) {
        log.info("Cancelling rent for property {} for customer {}", propertyId, customer.getId());
    }
    public Customer lookupCustomer(UUID customerId) {
        // Dummy code to simply unnecessary details
        return new Customer(customerId, "f", "l", "e@e");
    }
}
