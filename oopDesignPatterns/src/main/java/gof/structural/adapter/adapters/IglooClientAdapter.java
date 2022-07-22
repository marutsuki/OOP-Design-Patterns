package gof.structural.adapter.adapters;

import gof.structural.adapter.thirdparty.IglooClient;
import lombok.extern.log4j.Log4j2;

import java.util.Properties;

@Log4j2
public class IglooClientAdapter implements RealEstateAgencyClientAdapter {
    private IglooClient client;
    public IglooClientAdapter(IglooClient client) {
        this.client = client;
    }

    @Override
    public void rent(Properties properties) {
        client.rent(Long.parseLong(properties.getProperty("propertyId")), properties.getProperty("customerEmail"));
    }

    @Override
    public void cancel(Properties properties) {
        log.info("Cannot cancel rent request - Igloo client does not provide such methods to do so!");
    }
}
