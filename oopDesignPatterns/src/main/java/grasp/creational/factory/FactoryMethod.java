package grasp.creational.factory;

import lombok.Getter;

/**
 * Pattern Name: Factory Method
 *
 * The factory method is a simple pattern, often the first design pattern learnt.
 *
 * This pattern solves the issue of how does one manage complex object creation logic where different implementations
 * require different instances of a type.
 *
 * For example: We have many types of vehicles, however to operate these machines we may require people of different professions.
 *
 * Car -> driver
 * Ship -> sailor
 * Spaceship -> astronaut
 *
 * How do we effectively write code so that each vehicle can manage its own user(s)?
 *
 * The factory method says: create a common interface between the composing class and enforce all implementations to specify how they
 * want to create the dependant class.
 */
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
