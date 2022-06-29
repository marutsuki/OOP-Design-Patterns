package gof.creational.factory;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Pattern Name: Simple Factory
 *
 * The simple factory is a solution to the problem of incohesive code where a user of a particular object is also responsible
 * for the creation of that object. By separating object creation into a separate module, we are separating the concerns of object creation
 * away from the user.
 *
 * Note that the main method getDummy() is very simple. There is not much logic involved in creating the dummy classes;
 * all of them share the same outward appearance and there is no difference in instantiation. However, realistically, some objects
 * may involve different construction code logic, such as different constructor method signatures, this would probably need to be handled
 * with by for example a switch case statement.
 *
 * If the logic around creating an object is much more complex and involves many possible combination choices, it may be wiser to use
 * the Builder pattern.
 */
@Log4j2
public class SimpleFactory {

    public static final String propertiesFilePath = "gof/factory.config";
    public static final String defaultFactoryTargetClass = "grasp.creational.factory.DummyImplOne";

    private static final String factoryTargetClassKey = "factoryTargetClass";
    private Properties properties;

    public SimpleFactory() {
        this.properties = new Properties();
        try {
            log.info("SimpleFactory() - Loading factory properties file");
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFilePath));
        } catch (IOException e) {
            log.error("SimpleFactory() - Failed to load properties file: {}", propertiesFilePath);
            log.info("SimpleFactory() - Using default property parameters");
        }

    }
    public Dummy getDummy() {
        String targetClass = properties.getProperty(factoryTargetClassKey, defaultFactoryTargetClass);
        Dummy newInstance;
        // TODO: In practice, shouldn't catch all exceptions in one block, makes it harder to log and figure out what went wrong
        try {
            newInstance = (Dummy) Class.forName(targetClass).getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            log.error("SimpleFactory - getDummy() - Failed to instantiate class: {}", targetClass);
            newInstance = null;
        }

        return newInstance;
    }

    public String getFactoryTargetClass() {
        return properties.getProperty(factoryTargetClassKey, defaultFactoryTargetClass);
    }
}
