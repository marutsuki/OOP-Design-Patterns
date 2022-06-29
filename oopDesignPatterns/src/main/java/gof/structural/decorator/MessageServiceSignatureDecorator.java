package gof.structural.decorator;

public class MessageServiceSignatureDecorator extends MessageServiceDecorator {

    private String signature;
    public MessageServiceSignatureDecorator(MessageService wrappee, String signature) {
        super(wrappee);
        this.signature = signature;
    }

    /**
     * Adds a signature at the end of all messages before send
     * @param message The message to send
     */
    @Override
    public void send(String message) {
        getWrappee().send(message.concat("\r\n\r\n" + signature));
    }
}
