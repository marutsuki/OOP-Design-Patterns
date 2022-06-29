package gof.structural.decorator;

public class MessageServiceNotifyDecorator extends MessageServiceDecorator {
    private String phoneNumber;
    public MessageServiceNotifyDecorator(MessageService wrappee, String phoneNumber) {
        super(wrappee);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void send(String message) {
        NotificationService.getInstance().notify(phoneNumber, "You received a new message!");
        getWrappee().send(message);
    }
}
