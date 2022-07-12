package gof.behavioural.memento;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Controller {
    private DrawingBoard drawingBoard = new DrawingBoard();
    private Deque<DrawingBoard.DrawingBoardMemento> history = new ArrayDeque<>();

    public void updateState(Map<String, Object> toUpdate) {
        /* Update state of drawing board
           ...

         */
        // Save a snapshot
        history.push(drawingBoard.save());
    }

    public void undo() {
        if (history.size() <= 1) {
            return;
        }

        // Remove the latest snapshot and restore the previous
        history.pop();
        history.peek().restore();
    }
}
