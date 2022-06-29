package gof.creational.prototype;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Log4j2
public class PrototypeTest {

    @Test
    public void prototypeCloneTest() {
        Prototype cell = new Prototype("Cell 1");

        log.info("Cloning prototype with property {}", cell.getMutableProperty());
        Prototype cellTwo = cell.clone();

        Assertions.assertEquals("Cell 1", cellTwo.getMutableProperty());

        log.info("Cloned prototype has property {}", cellTwo.getMutableProperty());

        log.info("Changing clone property to Cell 2");
        cellTwo.setMutableProperty("Cell 2");

        Assertions.assertEquals("Cell 1", cell.getMutableProperty());
        Assertions.assertEquals("Cell 2", cellTwo.getMutableProperty());

        log.info("There are two Prototype objects, the first one containing {} and the second one containing {}", cell.getMutableProperty(), cellTwo.getMutableProperty());
    }
}
