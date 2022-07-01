package gof.creational.factory.factoryMethod;

import gof.creational.factory.Dummy;
import gof.creational.factory.DummyImplOne;

public class FactoryMethodOne extends FactoryMethod {
    @Override
    public Dummy createDummy() {
        return new DummyImplOne();
    }
}
