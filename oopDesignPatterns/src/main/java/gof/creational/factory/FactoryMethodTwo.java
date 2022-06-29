package gof.creational.factory;

public class FactoryMethodTwo extends FactoryMethod{
    @Override
    public Dummy createDummy() {
        return new DummyImplTwo();
    }
}
