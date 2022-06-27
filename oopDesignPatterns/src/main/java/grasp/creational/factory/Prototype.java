package grasp.creational.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Pattern name: Prototype
 *
 * This pattern can be simple and complex at the same time. However, the concept is very straightforward.
 *
 * Problem: How do we efficiently make duplicate objects at runtime?
 * If we need multiple instances of the same class with the same or similar attributes, how do we write clean code?
 *
 * Solution: Add a clone functionality to the desired class (This is done default in Java) that effectively clones the owner object
 * If more logic is required than a simple copy over the attributes cloning, this can be done in the clone method.
 */
@Getter
@Setter
@AllArgsConstructor
public class Prototype {

    private Object mutableProperty;

    @Override
    public Prototype clone() {
        return new Prototype(this.mutableProperty);
    }
}
