package gof.behavioural.mediator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ChatRoomParticipant extends Participant<ChatSendMessage, ChatReceiveMessage, ChatRoomMediator, ChatRoomParticipant> {
    private long id;
    private Long chatRoomId = null;

    public ChatRoomParticipant(long id, ChatRoomMediator crm) {
        super(crm);
        this.id = id;
    }

    @Override
    public void send(ChatSendMessage message) {
        mediator.handle(message);
    }

    @Override
    public void receive(ChatReceiveMessage message) {
        // Notify user client
    }

    public void send(String message) {
        if (chatRoomId == null) {
            throw new RuntimeException("User has not joined a chat room yet");
        }
        send(new ChatSendMessage(this, this.chatRoomId, message));
    }

    public void joinChatRoom(long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
}
