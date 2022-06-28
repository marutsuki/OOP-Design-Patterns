package grasp.structural.composite;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class CompositeTest {
    @Test
    public void renderSimpleShape() {
        Shape shape = new Circle(0, 0, 1);

        shape.render();
    }

    @Test
    public void renderComplexShape() {
        Shape childShapeOne = new Circle(0, 0, 1);
        Shape childShapeTwo = new Rectangle(0, 0, 2, 2);
        Shape parentShape = new ComplexShape(childShapeOne, childShapeTwo);

        parentShape.render();
    }

    @Test
    public void renderComplexComplexShape() {
        Shape childShapeOne = new Circle(0, 0, 1);
        Shape childShapeTwo = new Rectangle(0, 0, 2, 2);
        Shape parentShape = new ComplexShape(childShapeOne, childShapeTwo);

        Shape childShapeThree = new Circle(1, 1, 1);
        Shape superParentShape = new ComplexShape(childShapeThree, parentShape);

        superParentShape.render();
    }
}
