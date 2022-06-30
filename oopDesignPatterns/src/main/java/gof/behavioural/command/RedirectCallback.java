package gof.behavioural.command;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
public class RedirectCallback implements EventListenerCallback {
    private String redirectUrl;
    @Override
    public void exec(String... args) {
        log.info("Redirecting to {}", redirectUrl);
    }
}
