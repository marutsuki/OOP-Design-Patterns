package gof.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ComplexShape extends Shape {

    private List<Shape> children = new ArrayList<>();

    public ComplexShape(Shape... shapes) {
        for (Shape shape : shapes) {
            children.add(shape);
        }
    }
    @Override
    public double calculateArea() {
        double area = 0;
        for (Shape child : children) {
            area += child.calculateArea();
        }
        return area;
    }

    @Override
    public void render() {
        for (Shape child : children) {
            child.render();
        }
    }
}
