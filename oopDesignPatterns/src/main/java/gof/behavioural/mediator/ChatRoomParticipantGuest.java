package gof.behavioural.mediator;

public class ChatRoomParticipantGuest extends ChatRoomParticipant {
    public static final int GUEST_ID = 0;
    public ChatRoomParticipantGuest(ChatRoomMediator crm) {
        super(GUEST_ID, crm);
    }

    @Override
    public void joinChatRoom(long chatRoomId) {
        super.send(String.format("GUEST %d has joined the chat room! Hello World", getId()));
        super.joinChatRoom(chatRoomId);
    }
}
