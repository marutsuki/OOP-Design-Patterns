package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;
import lombok.Getter;

@Getter
public class MouseScrollEvent extends MouseEvent {
    private double deltaY;
    public MouseScrollEvent(Object source, double deltaY, int x, int y) {
        super(source, x, y);
        this.deltaY = deltaY;
    }
    @Override
    public void acceptVisitor(EventVisitor visitor) {
        visitor.visit(this);
    }
}
