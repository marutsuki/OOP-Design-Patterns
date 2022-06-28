package grasp.structural.adaptor;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IncompatibleInterfaceOne {

    public void waveHand() {
        log.info("{} just waved!", this.getClass().getSimpleName());
    }
    public void saySomething(String somethingToSay) {
        log.info("{} says: {}", this.getClass().getSimpleName(), somethingToSay);
    }
}
