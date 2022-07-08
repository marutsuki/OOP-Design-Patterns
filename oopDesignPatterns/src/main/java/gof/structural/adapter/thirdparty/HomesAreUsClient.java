package gof.structural.adapter.thirdparty;

import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@Log4j2
public class HomesAreUsClient {
    public void createRentRequest(HomesAreUsRequest request) {
        log.info("Creating request: {}", request);
    }
    public void cancelRentRequest(UUID id) {
        log.info("Cancelling request with id: {}", id);
        /**
         * Place here code for sending a remote request to HomesAreUs servers.
         */
    }
}
