package gof.behavioural.command;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
public class SaveCallback implements EventListenerCallback {
    @Override
    public void exec(String... args) {
        log.info("Values: {} have been saved", Arrays.toString(args));
    }
}
