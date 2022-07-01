package gof.creational.factory.factoryMethod;

import gof.creational.factory.Dummy;
import gof.creational.factory.DummyImplThree;

public class FactoryMethodThree extends FactoryMethod {
    @Override
    public Dummy createDummy() {
        return new DummyImplThree();
    }
}
