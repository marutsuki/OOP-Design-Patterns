package gof.behavioural.command;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
@AllArgsConstructor
public class AlertCallback implements EventListenerCallback {
    private String message;
    @Override
    public void exec(String... args) {
        log.info("ALERT: {}", message);
    }
}
