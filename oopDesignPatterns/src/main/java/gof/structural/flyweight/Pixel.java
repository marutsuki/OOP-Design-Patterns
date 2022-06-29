package gof.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pixel {
    private int xLoc;
    private int yLoc;
    private PixelType pixelType;
}
