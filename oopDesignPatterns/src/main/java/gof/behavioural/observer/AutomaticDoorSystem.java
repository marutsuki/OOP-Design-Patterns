package gof.behavioural.observer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AutomaticDoorSystem implements Subscriber<IntruderActivityContext> {
    private static final double LOCK_THRESHOLD = 0.75;
    @Override
    public void update(IntruderActivityContext context) {
        if (context.getPresenceLevel() > LOCK_THRESHOLD) {
            log.info("Locking automatic door system");
        }
    }
}
