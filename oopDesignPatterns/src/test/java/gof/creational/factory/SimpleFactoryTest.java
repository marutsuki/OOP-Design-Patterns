package gof.creational.factory;

import gof.creational.factory.simpleFactory.SimpleFactory;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Feel free to modify the factory.config file in /src/main/resources/grasp to modify the behaviour of the simple factory
 */
@Log4j2
public class SimpleFactoryTest {

    private SimpleFactory simpleFactory = new SimpleFactory();

    @Test
    public void getDummyTest() {
        Dummy dummy = this.simpleFactory.getDummy();

        Assertions.assertEquals(this.simpleFactory.getFactoryTargetClass(), dummy.getClass().getName());

        log.info("SimpleFactory has created an instance of {} in response to property value of {}", dummy.getClass().getName(), this.simpleFactory.getFactoryTargetClass());
        log.info("Dummy says: Hello I am {}", dummy.getName());
    }
}
