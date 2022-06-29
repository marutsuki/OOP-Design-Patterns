package gof.structural.decorator;

import lombok.Getter;

@Getter
public abstract class MessageServiceDecorator implements MessageService {

    private MessageService wrappee;

    public MessageServiceDecorator(MessageService wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}
