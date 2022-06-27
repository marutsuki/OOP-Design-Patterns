package grasp.creational.singleton;

import grasp.creational.singleton.Singleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void singletonTest() {
        Assertions.assertNotNull(Singleton.getInstance());

        Singleton.getInstance().sayHello();
    }
}
