package gof.behavioural.memento;

public class Shape implements DrawingBoardElement {
    enum ShapeType {
        RECTANGLE,
        CIRCLE,
        POLYGON
    }

    private ShapeType type;
    @Override
    public void render() {
        // Render shape
    }
}
