package gof.behavioural.visitor.visitors;

import gof.behavioural.visitor.subjects.MouseClickEvent;
import lombok.AllArgsConstructor;
import util.Pair;
import util.Thunk;

@AllArgsConstructor
public class ButtonComponent implements UIComponent, EventVisitor {
    private Thunk onClick;
    @Override
    public void visit(MouseClickEvent event) {
        // If the cursor was hovering over this component during click
        if (event.isOverlapping(this)) {
            // Execute the callback function
            this.onClick.apply();
        }
    }
    @Override
    public Pair<Integer, Integer> getPosition() {
        // Get position of component
        return null;
    }

    @Override
    public Pair<Integer, Integer> getSize() {
        // Get size of component
        return null;
    }

    @Override
    public void render() {
        // Render component
    }
}
