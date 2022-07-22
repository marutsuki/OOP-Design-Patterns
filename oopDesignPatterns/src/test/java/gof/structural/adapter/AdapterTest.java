package gof.structural.adapter;

import gof.structural.adapter.adapters.BuyHomesDotComClientAdapter;
import gof.structural.adapter.adapters.HomesAreUsClientAdapter;
import gof.structural.adapter.adapters.IglooClientAdapter;
import gof.structural.adapter.thirdparty.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import java.util.Properties;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AdapterTest {
    private String uuidOne = "ba0fe015-037b-4d1a-a4a2-292525e02c5a";
    private String uuidTwo = "0fe94c1a-b7bb-402b-be30-5cfe34e1b54c";
    private Customer customer = new Customer(UUID.fromString(uuidOne), "l", "l", "l@l");;
    @Mock
    private BuyHomesDotComClient buyHomesDotComClient;
    @Mock
    private HomesAreUsClient homesAreUsClient;
    @Mock
    private IglooClient iglooClient;
    @InjectMocks
    private BuyHomesDotComClientAdapter buyHomesDotComClientAdapter;
    @InjectMocks
    private HomesAreUsClientAdapter homesAreUsClientAdapter;
    @InjectMocks
    private IglooClientAdapter iglooClientAdapter;

    @Test
    public void buyHomesDotComClientAdapterRentTest() {
        Properties properties = new Properties();
        properties.put("propertyId", "123");
        properties.put("customerId", uuidOne);

        when(buyHomesDotComClient.lookupCustomer(eq(UUID.fromString(uuidOne)))).thenReturn(customer);
        buyHomesDotComClientAdapter.rent(properties);
        verify(buyHomesDotComClient, times(1)).lookupCustomer(eq(UUID.fromString(uuidOne)));
        verify(buyHomesDotComClient, times(1)).rentProperty(123L, customer);
    }

    @Test
    public void homesAreUsClientAdapterRentTest() {
        Properties properties = new Properties();
        properties.put("propertyId", uuidTwo);
        properties.put("startDate", "01-01-2022");
        properties.put("customerName", "Lucien");
        properties.put("customerEmail", "lucien.7789@gmail.com");
        properties.put("customerPhone", "+0433 333 333");
        homesAreUsClientAdapter.rent(properties);
        verify(homesAreUsClient, times(1)).createRentRequest(any(HomesAreUsRequest.class));
    }

    @Test
    public void iglooClientAdapterRentTest() {
        Properties properties = new Properties();
        properties.put("propertyId", "777");
        properties.put("customerEmail", "lucien.7789@gmail.com");
        iglooClientAdapter.rent(properties);
        verify(iglooClient, times(1)).rent(777L, "lucien.7789@gmail.com");
    }

    @Test
    public void buyHomesDotComClientAdapterCancelTest() {
        Properties properties = new Properties();
        properties.put("propertyId", "123");
        properties.put("customerId", uuidOne);

        when(buyHomesDotComClient.lookupCustomer(eq(UUID.fromString(uuidOne)))).thenReturn(customer);

        buyHomesDotComClientAdapter.cancel(properties);
        verify(buyHomesDotComClient, times(1)).cancelRent(123L, customer);
    }

    @Test
    public void homesAreUsClientAdapterCancelTest() {
        Properties properties = new Properties();
        properties.put("requestId", uuidTwo);

        homesAreUsClientAdapter.cancel(properties);

        verify(homesAreUsClient, times(1)).cancelRentRequest(eq(UUID.fromString(uuidTwo)));
    }
    
    @Test
    public void iglooClientAdapterCancelTest() {
        // Nothing to test
    }
}
