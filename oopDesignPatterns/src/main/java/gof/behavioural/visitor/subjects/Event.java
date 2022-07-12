package gof.behavioural.visitor.subjects;

import lombok.Getter;

@Getter
public abstract class Event implements EventSubject {
    private final Object source;
    public Event(Object source) {
        this.source = source;
    }
}
