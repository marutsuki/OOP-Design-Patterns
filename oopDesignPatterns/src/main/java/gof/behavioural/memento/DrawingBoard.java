package gof.behavioural.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
public class DrawingBoard {
    private List<DrawingBoardComponent> drawingBoardComponents;
    private String name;
    private String description;
    private int sizeX;
    private int sizeY;
    @AllArgsConstructor
    @Getter
    class DrawingBoardMemento {
        private DrawingBoard subject;
        private List<DrawingBoardComponent> drawingBoardComponents;
        private String name;
        private String description;
        private int sizeX;
        private int sizeY;

        public void restore() {
            subject.setDrawingBoardComponents(this.drawingBoardComponents);
            subject.setName(this.name);
            subject.setDescription(this.description);
            subject.setSizeX(this.sizeX);
            subject.setSizeY(this.sizeY);
        }
    }

    public DrawingBoardMemento save() {
        return new DrawingBoardMemento(
                this, drawingBoardComponents.stream().map(c -> c.clone()).toList(), name, description, sizeX, sizeY);
    }
}
