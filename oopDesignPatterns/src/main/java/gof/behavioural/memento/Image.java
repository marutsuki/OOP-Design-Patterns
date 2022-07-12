package gof.behavioural.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Image implements DrawingBoardElement {
    private String fPath;

    @Override
    public void render() {
        // Render image in fPath
    }
}
