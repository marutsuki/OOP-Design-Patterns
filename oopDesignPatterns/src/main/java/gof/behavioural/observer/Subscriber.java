package gof.behavioural.observer;

public interface Subscriber<T extends Context> {
    void update(T context);
}
