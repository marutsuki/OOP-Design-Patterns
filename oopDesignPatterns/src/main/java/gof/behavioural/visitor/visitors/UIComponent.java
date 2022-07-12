package gof.behavioural.visitor.visitors;

import util.Pair;

public interface UIComponent {
    Pair<Integer, Integer> getPosition();
    Pair<Integer, Integer> getSize();
    void render();
}
