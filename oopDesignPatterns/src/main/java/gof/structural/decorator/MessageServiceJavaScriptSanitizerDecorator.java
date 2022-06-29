package gof.structural.decorator;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class MessageServiceJavaScriptSanitizerDecorator extends MessageServiceDecorator {
    public MessageServiceJavaScriptSanitizerDecorator(MessageService wrappee) {
        super(wrappee);
    }

    /**
     * Decorator method to escape HTML and prevent XSS
     * @param message The message to send
     */
    @Override
    public void send(String message) {
        String escaped = Jsoup.clean(message, Safelist.basic());
        getWrappee().send(escaped);
    }
}
