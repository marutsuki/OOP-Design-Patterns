package gof.creational.factory.simpleFactory;

import gof.creational.factory.Dummy;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
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
