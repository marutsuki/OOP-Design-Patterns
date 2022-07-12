package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;
import lombok.Getter;

@Getter
public class KeyPressEvent extends Event {
    private Key keyValue;
    public KeyPressEvent(Object source, Key keyValue) {
        super(source);
        this.keyValue = keyValue;
    }
    @Override
    public void acceptVisitor(EventVisitor visitor) {
        visitor.visit(this);
    }
}
