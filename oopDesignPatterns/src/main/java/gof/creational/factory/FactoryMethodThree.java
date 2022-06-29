package gof.creational.factory;

public class FactoryMethodThree extends FactoryMethod {
    @Override
    public Dummy createDummy() {
        return new DummyImplThree();
    }
}
