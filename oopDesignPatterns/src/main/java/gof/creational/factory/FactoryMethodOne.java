package gof.creational.factory;

public class FactoryMethodOne extends FactoryMethod {
    @Override
    public Dummy createDummy() {
        return new DummyImplOne();
    }
}
