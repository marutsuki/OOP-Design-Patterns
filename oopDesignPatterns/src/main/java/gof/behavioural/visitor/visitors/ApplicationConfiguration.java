package gof.behavioural.visitor.visitors;

import gof.behavioural.visitor.subjects.MouseScrollEvent;
import gof.behavioural.visitor.subjects.WindowLoadedEvent;
import gof.behavioural.visitor.subjects.WindowResizeEvent;
import lombok.Getter;

@Getter
public class ApplicationConfiguration implements EventVisitor {
    private int windowHeight;
    private int windowWidth;
    private int displayOffsetY;
    private boolean applicationReady = false;
    @Override
    public void visit(WindowResizeEvent event) {
        // Readjust configuration so every other component will know
        this.windowHeight = event.getNewHeight();
        this.windowWidth = event.getNewWidth();
    }
    @Override
    public void visit(MouseScrollEvent event) {
        this.displayOffsetY += event.getDeltaY();
    }
    @Override
    public void visit(WindowLoadedEvent event) {
        this.applicationReady = true;
    }
}
