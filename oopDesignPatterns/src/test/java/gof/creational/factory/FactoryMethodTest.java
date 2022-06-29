package gof.creational.factory;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Log4j2
public class FactoryMethodTest {

    private FactoryMethod factoryMethodOne = new FactoryMethodOne();
    private FactoryMethod factoryMethodTwo = new FactoryMethodTwo();
    private FactoryMethod factoryMethodThree = new FactoryMethodThree();

    @Test
    public void factoryMethodOneTest() {
        Assertions.assertEquals(DummyImplOne.class.getSimpleName(), factoryMethodOne.getTarget().getName());

        log.info("Dummy from factoryMethodOne says: {}", factoryMethodOne.getMessage());
    }

    @Test
    public void factoryMethodTwoTest() {
        Assertions.assertEquals(DummyImplTwo.class.getSimpleName(), factoryMethodTwo.getTarget().getName());

        log.info("Dummy from factoryMethodTwo says: {}", factoryMethodTwo.getMessage());
    }

    @Test
    public void factoryMethodThreeTest() {
        Assertions.assertEquals(DummyImplThree.class.getSimpleName(), factoryMethodThree.getTarget().getName());

        log.info("Dummy from factoryMethodThree says: {}", factoryMethodThree.getMessage());
    }
}
