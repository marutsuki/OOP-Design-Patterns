package gof.behavioural.command;

public class EventListener {
    private EventListenerCallback eventListenerCallback;
    public void notify(String... args) {
        eventListenerCallback.exec(args);
    }
}
