package gof.behavioural.observer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AlarmSystem implements Subscriber<IntruderActivityContext> {
    private static final double alarmThreshold = 0.9;
    @Override
    public void update(IntruderActivityContext context) {
        log.info("Alarm is now ringing! Message being played: {}", context.getMessage());
    }
}
