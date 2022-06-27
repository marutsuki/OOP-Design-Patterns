package grasp.creational.singleton;

import lombok.extern.log4j.Log4j2;

/**
 * Pattern name: Singleton
 *
 * Problem: How do we enforce up to a single instance of a class? How do we allow global access to an object while following
 * object-oriented paradigm?
 *
 * Solution: Create a class whose constructor can only be accessed by itself, which effectively restricts the user access on the
 * object to what it defines itself.
 *
 * The class should hold a static instance of itself which it instantiates when required.
 *
 * Finally, a getInstance() method should be provided to the external user to allow them access to this one object.
 */
@Log4j2
public class Singleton {

    private static Singleton instance;

    /**
     * Note the private constructor is very important in ensuring that it is a "singleton"
     */
    private Singleton() {}

    public void sayHello() {
        log.info("Singleton says hello!");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
