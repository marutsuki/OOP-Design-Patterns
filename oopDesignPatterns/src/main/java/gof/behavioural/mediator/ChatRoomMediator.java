package gof.behavioural.mediator;

public class ChatRoomMediator extends Mediator<ChatSendMessage, ChatReceiveMessage, ChatRoomMediator, ChatRoomParticipant> {
    private static final String SYSTEM_USERNAME = "SYSTEM";
    private static final long GLOBAL_MESSAGE_CHATROOM = -1;
    private final UserDao userDao = UserDao.getInstance();

    /**
     * We are centralizing all communication logic into the mediator
     * The logic is split into 2 parts - The sending logic, the receiving logic
     */
    @Override
    public void handle(ChatSendMessage message) {
        handleMessage(message);
    }
    public void handleMessage(ChatSendMessage message) {
        var chatRoomId = message.getChatRoomId();
        var sender = message.getSender();
        var senderUsername = getUsername(sender.getId());

        /*
          Extremely long switches are a sign of bad design - we should refactor each case to a particular handler class
          and use a Factory to determine which handler class to instantiate. Otherwise, we can use the Visitor pattern.
         */

        switch (sender) {
            case ChatRoomParticipantAdmin ignored -> {
                if (checkSetting("GLOBAL").equals("TRUE")) {
                    forwardChatMessage(GLOBAL_MESSAGE_CHATROOM, senderUsername, message.getMessage());
                }
            }
            case ChatRoomParticipantGuest ignored -> {
                if (guestCheck(message.getMessage())) {
                    forwardChatMessage(chatRoomId, senderUsername, message.getMessage());
                } else {
                    sender.receive(new ChatReceiveMessage(SYSTEM_USERNAME,
                            "Your message cannot be sent: it contains exclusive features only available to users"));
                }
            }
            case ChatRoomParticipantUser ignored -> {
                if (userDao.isBanned(sender.getId())) {
                    forwardChatMessage(chatRoomId, senderUsername, senderUsername);
                } else {
                    sender.receive(new ChatReceiveMessage(SYSTEM_USERNAME,
                            "Your message cannot be sent: your account is banned"));
                }
            }
            default -> sender.receive(new ChatReceiveMessage(SYSTEM_USERNAME,
                    "Your message cannot be sent: we could not verify your account type. Please try again later"));
        }
    }
    private void forwardChatMessage(long chatRoomId, String senderUsername, String message) {
        ChatReceiveMessage receiveMessage = new ChatReceiveMessage(
                senderUsername,
                message);

        for (ChatRoomParticipant participant : participants) {
            switch (participant) {
                case ChatRoomParticipantAdmin ignored -> participant.receive(receiveMessage);
                case ChatRoomParticipantGuest ignored -> {
                    if (guestCheck(message)) {
                        participant.receive(receiveMessage);
                    }
                }
                case ChatRoomParticipantUser ignored -> {
                    if (userDao.isBanned(participant.getId()) && participant.getChatRoomId() == chatRoomId) {
                        participant.receive(receiveMessage);
                    }
                }
                default -> participant.receive(new ChatReceiveMessage(SYSTEM_USERNAME,
                        "You received a message, however we could not verify your account type."));
            }

        }
    }
    private String checkSetting(String ignored) {
        // Check if a property is set to true
        return "";
    }
    private boolean guestCheck(String ignored) {
        // Check if message contains exclusive features hidden from guests. etc. GIFs, Emojis.
        return (Math.random() < 0.5);
    }
    private String getUsername(long id) {
        return id == ChatRoomParticipantGuest.GUEST_ID ? "GUEST" : userDao.lookupUsername(id);
    }
}
