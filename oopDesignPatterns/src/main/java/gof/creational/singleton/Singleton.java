package gof.creational.singleton;

import lombok.extern.log4j.Log4j2;
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
