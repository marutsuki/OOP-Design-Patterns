package gof.behavioural.visitor.visitors;

import gof.behavioural.visitor.subjects.ExitFocusEvent;
import gof.behavioural.visitor.subjects.FocusEvent;
import gof.behavioural.visitor.subjects.KeyPressEvent;
import util.Pair;

public class UIInputComponent implements EventVisitor, UIComponent {
    private boolean active = false;
    private StringBuilder value = new StringBuilder();
    @Override
    public void visit(KeyPressEvent event) {
        // Only attempt to modify the input if this component is active
        if (this.active == true) {
            var keyValue = event.getKeyValue();
            if (keyValue.name() == "DELETE" && value.length() > 0) {
                value.deleteCharAt(value.length() - 1);
            } else if (keyValue.isInput()){
                value.append(keyValue.name());
            }
        }
    }
    @Override
    public void visit(FocusEvent event) {
        this.active = true;
    }
    @Override
    public void visit(ExitFocusEvent event) {
        this.active = false;
    }
    @Override
    public Pair<Integer, Integer> getPosition() {
        // Get the position of the component
        return null;
    }

    @Override
    public Pair<Integer, Integer> getSize() {
        // Get the size of the component
        return null;
    }

    @Override
    public void render() {
        // Render UI Component
    }
}
