package gof.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PixelType {
    private char red;
    private char green;
    private char blue;
    private double transparency;
}
