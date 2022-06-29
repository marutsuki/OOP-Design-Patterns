package gof.structural.adaptor;

import org.junit.jupiter.api.Test;

public class AdaptorTest {
    @Test
    public void adaptorTest() {
        // Note how all three adaptors can be interchanged
        Adaptor adaptorOne = new AdaptorInterfaceOne();
        Adaptor adaptorTwo = new AdaptorInterfaceTwo();
        Adaptor adaptorThree = new AdaptorInterfaceThree();

        adaptorOne.greet();
        adaptorTwo.greet();
        adaptorThree.greet();
    }
}
