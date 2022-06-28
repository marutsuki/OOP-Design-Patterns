package grasp.structural.adaptor;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IncompatibleInterfaceTwo {
    public void log(String... messages) {
        for (String m : messages) {
            log.info(m);
        }
    }
}
