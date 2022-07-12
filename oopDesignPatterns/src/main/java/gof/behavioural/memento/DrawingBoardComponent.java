package gof.behavioural.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DrawingBoardComponent {
    private DrawingBoardElement element;
    private int posX;
    private int posY;
    private int width;
    private int height;

    @Override
    public DrawingBoardComponent clone() {
        return new DrawingBoardComponent(this.element, posX, posY, width, height);
    }
}
