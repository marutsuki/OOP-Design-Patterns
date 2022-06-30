package gof.behavioural.observer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PhoneClientApi implements Subscriber<IntruderActivityContext> {
    @Override
    public void update(IntruderActivityContext context) {
        log.info("Phone: Activity detected at a level of {}, message: {}",
                context.getPresenceLevel(), context.getMessage());
    }
}
