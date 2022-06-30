package gof.behavioural.observer;

public class ActivityMonitor extends Publisher<IntruderActivityContext> {
    private static final double ALERT_THRESHOLD = 0.1;
    private double presenceLevel = 0;
    public void scan() {
        presenceLevel = Math.random();
        if (presenceLevel >= ALERT_THRESHOLD) {
            updateAll(new IntruderActivityContext(presenceLevel, "Warning: potential intruder"));
        }
    }
}
