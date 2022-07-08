package gof.structural.adapter.thirdparty;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IglooClient {

    public void rent(long propertyId, String customerEmail) {
        log.info("Creating rent record for property id: {} and customer email: {}", propertyId, customerEmail);
    }
}
