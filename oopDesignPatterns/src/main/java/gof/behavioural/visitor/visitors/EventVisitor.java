package gof.behavioural.visitor.visitors;

import gof.behavioural.visitor.subjects.*;

public interface EventVisitor {
    default void visit(KeyPressEvent event) {
        return;
    }
    default void visit(MouseClickEvent event) {
        return;
    }
    default void visit(MouseScrollEvent event) {
        return;
    }
    default void visit(WindowLoadedEvent event) {
        return;
    }
    default void visit(WindowResizeEvent event) {
        return;
    }
    default void visit(FocusEvent event) {
        return;
    }
    default void visit(ExitFocusEvent event) {
        return;
    }
}
