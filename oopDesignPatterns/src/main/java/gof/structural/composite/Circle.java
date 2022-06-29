package gof.structural.composite;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Circle extends Shape {
    public static double pi = 3.14;
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return pi * Math.pow(radius, 2);
    }

    @Override
    public void render() {
        log.info("Rendering Circle of radius: {} at coordinates: ({}, {})", radius, getX(), getY());
    }
}
