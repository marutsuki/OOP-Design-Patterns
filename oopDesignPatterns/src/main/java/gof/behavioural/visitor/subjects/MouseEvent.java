package gof.behavioural.visitor.subjects;

import gof.behavioural.visitor.visitors.UIComponent;
import lombok.Getter;
import util.Pair;

@Getter
public abstract class MouseEvent extends Event {
    private Pair<Integer, Integer> position;
    public MouseEvent(Object source, int x, int y) {
        super(source);
        this.position = new Pair<>(x, y);
    }
    public boolean isOverlapping(UIComponent uiComponent) {
        var mouseClickLocation = getPosition();
        var uiComponentLocation = uiComponent.getPosition();
        var uiComponentSize = uiComponent.getSize();

        return mouseClickLocation.getT1() >= uiComponentLocation.getT1()
                && mouseClickLocation.getT2() >= uiComponentLocation.getT2()
                && mouseClickLocation.getT1() <= (uiComponentLocation.getT1() + uiComponentSize.getT1())
                && mouseClickLocation.getT2() <= (uiComponentLocation.getT2() + uiComponentSize.getT2());
    }
}
