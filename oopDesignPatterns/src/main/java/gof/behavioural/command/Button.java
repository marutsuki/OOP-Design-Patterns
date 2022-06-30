package gof.behavioural.command;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private List<EventListener> observers = new ArrayList<>();
    public void addEventListener(EventListener eventListener) {
        observers.add(eventListener);
    }
    public void removeEventListener(EventListener eventListener) {
        observers.remove(eventListener);
    }
    public void onClick() {
        for (EventListener el : observers) {
            el.notify();
        }
    }
}
