package gof.structural.decorator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessageServiceLoggerDecorator extends MessageServiceDecorator {
    public MessageServiceLoggerDecorator(MessageService wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        log.info("Message has been sent through MessageService: {}", message);
        getWrappee().send(message);
    }
}
