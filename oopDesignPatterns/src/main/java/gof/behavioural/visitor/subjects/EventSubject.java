package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;

public interface EventSubject {
    void acceptVisitor(EventVisitor visitor);
}
