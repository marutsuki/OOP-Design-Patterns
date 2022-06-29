package gof.structural.composite;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double x, double y, double height, double width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public void render() {
        log.info("Rendering Square of height: {}, width: {} at coordinates: ({}, {})", height, width, getX(), getY());
    }
}
