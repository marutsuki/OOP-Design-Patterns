package reflection.multiclass;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

@Log4j2
public class MulticlassQuerierTest {

    private MulticlassQuerier multiclassQuerier = new MulticlassQuerier();
    @Test
    public void queryGenericInterfaceTest() {
        Queryable one = new QueryableOne();
        Queryable two = new QueryableOne();
        Queryable three = new QueryableOne();
        multiclassQuerier.addQueryable(one);
        multiclassQuerier.addQueryable(two);
        multiclassQuerier.addQueryable(three);

        Assertions.assertEquals(3, multiclassQuerier.queryOfType(Object.class).size());

        log.info("Added {}, {}, {} and got {} with type query {}",
                one, two, three, multiclassQuerier.queryOfType(Object.class).toString(), Object.class);
    }

    @Test
    public void querySpecificInterfaceTest() {
        Queryable one = new QueryableOne();
        Queryable two = new QueryableComparable();
        Queryable three = new QueryableSerializable();
        multiclassQuerier.addQueryable(one);
        multiclassQuerier.addQueryable(two);
        multiclassQuerier.addQueryable(three);

        Assertions.assertEquals(1, multiclassQuerier.queryOfType(Serializable.class).size());

        log.info("Added {}, {}, {} and got {} with type query {}",
                one, two, three, multiclassQuerier.queryOfType(Serializable.class).toString(), Serializable.class);
    }
}
