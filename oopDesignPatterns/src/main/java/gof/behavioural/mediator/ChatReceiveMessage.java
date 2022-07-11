package gof.behavioural.mediator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatReceiveMessage {
    private String senderUsername;
    private String senderMessage;
}
