package gof.behavioural.mediator;

public class ChatRoomParticipantAdmin extends ChatRoomParticipant {
    public ChatRoomParticipantAdmin(long id, ChatRoomMediator crm) {
        super(id, crm);
    }

    @Override
    public void joinChatRoom(long chatRoomId) {
        super.send(String.format("ADMIN %d has joined the chat room! Uh oh, someone's misbehaving!", getId()));
        super.joinChatRoom(chatRoomId);
    }
}
