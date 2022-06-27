package grasp.creational.builder;

import grasp.creational.builder.Builder;
import grasp.creational.builder.ComplexDummy;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Log4j2
public class BuilderTest {

    private Builder builder = new Builder();
    @Test
    public void builderSimpleTest() {
        ComplexDummy creation = builder.init().changeName("Dummy").build();

        Assertions.assertEquals("Dummy", creation.getName());

        log.info("Builder created ComplexDummy with name: {}", creation.getName());
    }

    @Test
    public void builderComplexTest() {
        ComplexDummy creation = builder.init()
                .changeName("Dummy")
                .setProperty("Property")
                .addToList("Item 1")
                .addToList("Item 2")
                .addMapping("Key", "Value")
                .build();

        Assertions.assertEquals("Dummy", creation.getName());
        Assertions.assertEquals("Property", creation.getProperty());
        Assertions.assertEquals(2, creation.getListOfObjects().size());
        Assertions.assertEquals("Item 1", creation.getListOfObjects().get(0));
        Assertions.assertEquals("Item 2", creation.getListOfObjects().get(1));
        Assertions.assertEquals(1, creation.getMapOfObjects().size());
        Assertions.assertEquals("Value", creation.getMapOfObjects().get("Key"));

        log.info("Builder created ComplexDummy with values:\nname: {}\nproperty: {}\nlistOfObjects: {}\nmapOfObjects: {}",
                creation.getName(),
                creation.getProperty(),
                creation.getListOfObjects().toString(),
                creation.getMapOfObjects().toString());
    }
}
