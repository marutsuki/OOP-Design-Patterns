package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;
import lombok.Getter;

@Getter
public class ExitFocusEvent extends Event {
    private Object target;
    public ExitFocusEvent(Object source, Object target) {
        super(source);
        this.target = target;
    }
    @Override
    public void acceptVisitor(EventVisitor visitor) {
        visitor.visit(this);
    }
}
