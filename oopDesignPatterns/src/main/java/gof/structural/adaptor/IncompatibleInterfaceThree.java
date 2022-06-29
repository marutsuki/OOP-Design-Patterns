package gof.structural.adaptor;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IncompatibleInterfaceThree {

    public void greet() {
        String name = this.getClass().getSimpleName();
        log.info("{} just waved!", name);
        log.info("{} says: Hello there", name);

    }
}
