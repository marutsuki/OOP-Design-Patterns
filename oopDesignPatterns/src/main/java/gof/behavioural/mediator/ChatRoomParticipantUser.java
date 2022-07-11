package gof.behavioural.mediator;

public class ChatRoomParticipantUser extends ChatRoomParticipant {
    public ChatRoomParticipantUser(long id, ChatRoomMediator crm) {
        super(id, crm);
    }

    @Override
    public void joinChatRoom(long chatRoomId) {
        super.send(String.format("USER %d has joined the chat room! Hello World", getId()));
        super.joinChatRoom(chatRoomId);
    }
}
