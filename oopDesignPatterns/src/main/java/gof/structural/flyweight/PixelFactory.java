package gof.structural.flyweight;

public class PixelFactory {

    public Pixel getPixel(int xLoc, int yLoc, char red, char green, char blue, double transparency) {
        // Retrieve the flyweight object
        PixelType pixelType = PixelFlyweightLibrary.getInstance().getPixelType(red, green, blue, transparency);

        // Create the actual pixel
        return new Pixel(xLoc, yLoc, pixelType);
    }
}
