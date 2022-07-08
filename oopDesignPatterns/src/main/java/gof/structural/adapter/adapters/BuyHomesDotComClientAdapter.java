package gof.structural.adapter.adapters;

import gof.structural.adapter.thirdparty.BuyHomesDotComClient;
import gof.structural.adapter.thirdparty.Customer;

import java.util.Properties;
import java.util.UUID;

public class BuyHomesDotComClientAdapter implements RealEstateAgencyClientAdapter {
    private BuyHomesDotComClient client = new BuyHomesDotComClient();

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
