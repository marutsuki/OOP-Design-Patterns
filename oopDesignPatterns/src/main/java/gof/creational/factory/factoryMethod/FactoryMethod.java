package gof.creational.factory.factoryMethod;

import gof.creational.factory.Dummy;
import lombok.Getter;
@Getter
public abstract class FactoryMethod {

    private Dummy target;

    public FactoryMethod() {
        this.target = createDummy();
    }
    public String getMessage() {
        return "Hello, I am ".concat(target.getName());
    }
    public abstract Dummy createDummy();
}
