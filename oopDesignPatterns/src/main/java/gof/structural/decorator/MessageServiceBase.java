package gof.structural.decorator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessageServiceBase implements MessageService {

    private MessageReceiver messageReceiver;
    public MessageServiceBase(MessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
    }
    @Override
    public void send(String message) {
        log.info("Sending message: {}", message);
        messageReceiver.receive(message);
    }
}
