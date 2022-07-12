package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;
import lombok.Getter;

@Getter
public class FocusEvent extends Event {
    private Object target;
    public FocusEvent(Object source, Object target) {
        super(source);
        this.target = target;
    }
    @Override
    public void acceptVisitor(EventVisitor visitor) {
        visitor.visit(this);
    }
}
