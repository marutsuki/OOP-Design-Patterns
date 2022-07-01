package gof.creational.factory.factoryMethod;

import gof.creational.factory.Dummy;
import gof.creational.factory.DummyImplTwo;

public class FactoryMethodTwo extends FactoryMethod{
    @Override
    public Dummy createDummy() {
        return new DummyImplTwo();
    }
}
