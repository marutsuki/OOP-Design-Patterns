package gof.behavioural.mediator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatSendMessage {
    private ChatRoomParticipant sender;
    private long chatRoomId;
    private String message;
}
