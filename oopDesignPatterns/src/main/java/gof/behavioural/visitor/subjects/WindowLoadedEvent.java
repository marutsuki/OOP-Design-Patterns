package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.EventVisitor;
import lombok.Getter;

@Getter
public class WindowLoadedEvent extends WindowEvent {
    private double timeTaken;
    public WindowLoadedEvent(Object source, double timeTaken) {
        super(source);
        this.timeTaken = timeTaken;
    }
    @Override
    public void acceptVisitor(EventVisitor visitor) {
        visitor.visit(this);
    }
}
