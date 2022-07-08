package gof.structural.adapter.thirdparty;

import lombok.Data;

import java.util.Calendar;
import java.util.UUID;

@Data
public class HomesAreUsRequest {
    Calendar startDate;
    UUID rentId = UUID.randomUUID();
    UUID propertyId;
    String customerName;
    String customerEmail;
    String phone;

    public HomesAreUsRequest(Calendar startDate, UUID propertyId, String customerName, String customerEmail, String phone) {
        this.startDate = startDate;
        this.propertyId = propertyId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phone = phone;
    }
}