package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;
import lombok.Getter;

@Getter
public class MouseClickEvent extends MouseEvent {
    private MouseClickType type;
    public MouseClickEvent(Object source, MouseClickType type, int x, int y) {
        super(source, x, y);
        this.type = type;
    }
    @Override
    public void acceptVisitor(EventVisitor visitor) {
        visitor.visit(this);
    }
}
