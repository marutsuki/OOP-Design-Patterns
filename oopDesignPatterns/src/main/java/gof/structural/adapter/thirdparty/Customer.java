package gof.structural.adapter.thirdparty;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Customer {
    UUID id;
    String firstName;
    String lastName;
    String contactEmail;
}
