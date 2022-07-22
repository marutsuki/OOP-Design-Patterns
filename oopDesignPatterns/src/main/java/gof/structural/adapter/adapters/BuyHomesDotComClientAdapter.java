package gof.structural.adapter.adapters;

import gof.structural.adapter.thirdparty.BuyHomesDotComClient;
import gof.structural.adapter.thirdparty.Customer;

import java.util.Properties;
import java.util.UUID;

public class BuyHomesDotComClientAdapter implements RealEstateAgencyClientAdapter {
    private BuyHomesDotComClient client;
    public BuyHomesDotComClientAdapter(BuyHomesDotComClient client) {
        this.client = client;
    }

    @Override
    public void rent(Properties properties) {
        long propertyId = Long.valueOf(properties.getProperty("propertyId"));
        Customer customer = client.lookupCustomer(UUID.fromString(properties.getProperty("customerId")));
        client.rentProperty(propertyId, customer);
    }

    @Override
    public void cancel(Properties properties) {
        long propertyId = Long.valueOf(properties.getProperty("propertyId"));
        Customer customer = client.lookupCustomer(UUID.fromString(properties.getProperty("customerId")));
        client.cancelRent(propertyId, customer);
    }
}
