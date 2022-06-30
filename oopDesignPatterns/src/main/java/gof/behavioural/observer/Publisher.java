package gof.behavioural.observer;

import java.util.List;

public abstract class Publisher<T extends Context> {
    private List<Subscriber<T>> subscribers;

    public void updateAll(T context) {
        for (Subscriber s : subscribers) {
            s.update(context);
        }
    }
}
