package gof.structural.adapter.adapters;

import gof.structural.adapter.thirdparty.HomesAreUsClient;
import gof.structural.adapter.thirdparty.HomesAreUsRequest;
import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

@Log4j2
public class HomesAreUsClientAdapter implements RealEstateAgencyClientAdapter {
    private HomesAreUsClient client = new HomesAreUsClient();

    @Override
    public void rent(Properties properties) {
        try {
            Calendar startDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            startDate.setTime(sdf.parse(properties.getProperty("startDate")));
            HomesAreUsRequest request = new HomesAreUsRequest(
                    startDate,
                    UUID.fromString(properties.getProperty("propertyId")),
                    properties.getProperty("customerName"),
                    properties.getProperty("customerEmail"),
                    properties.getProperty("customerPhone")
            );
            client.createRentRequest(request);
        } catch (ParseException e) {
            log.info("Failed to parse startDate - cancelling request");
        }
    }

    @Override
    public void cancel(Properties properties) {
        UUID requestToCancel = UUID.fromString(properties.getProperty("requestId"));
        client.cancelRentRequest(requestToCancel);
    }
}
