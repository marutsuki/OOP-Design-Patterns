package gof.behavioural.command;

@FunctionalInterface
public interface EventListenerCallback {
    void exec(String... args);
}
