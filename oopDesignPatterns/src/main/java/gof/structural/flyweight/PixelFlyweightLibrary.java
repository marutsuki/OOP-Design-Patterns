package gof.structural.flyweight;

import util.Quadtriplet;

import java.util.HashMap;
import java.util.Map;

public class PixelFlyweightLibrary {
    private static PixelFlyweightLibrary instance;
    private Map<Quadtriplet<Character, Character, Character, Double>, PixelType> cache = new HashMap<>();

    private PixelFlyweightLibrary() {}

    public static PixelFlyweightLibrary getInstance() {
        if (instance == null) {
            instance = new PixelFlyweightLibrary();
        }
        return instance;
    }

    public PixelType getPixelType(char red, char green, char blue, double transparency) {
        PixelType pixelType = cache.get(
                new Quadtriplet<>(red, green, blue, transparency));
        if (pixelType == null) {
            pixelType = new PixelType(red, green, blue, transparency);
            cache.put(new Quadtriplet<>(red, green, blue, transparency),
                    pixelType);
        }
        return pixelType;
    }
}
