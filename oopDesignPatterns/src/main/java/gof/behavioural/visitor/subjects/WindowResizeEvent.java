package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;
import lombok.Getter;

@Getter
public class WindowResizeEvent extends WindowEvent {
    private int newHeight;
    private int newWidth;
    public WindowResizeEvent(Object source, int newHeight, int newWidth) {
        super(source);
        this.newHeight = newHeight;
        this.newWidth = newWidth;
    }
    @Override
    public void acceptVisitor(EventVisitor visitor) {
        visitor.visit(this);
    }
}
