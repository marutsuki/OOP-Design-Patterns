package reflection.multiclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern name: Multiclass Querier
 *
 * Author: Lucien Lu @ 2021, lucien.7789@gmail.com
 *
 * This was a Java-centric pattern I came up with during one of my programming courses at university.
 *
 * Problem: How do we write clean code and implement a central intelligence that knows all the objects in a specific domain while allowing the user
 * to filter out the specific objects they want?
 *
 * For example, what if we wanted to know all the objects that implement X interface? Then Y interface?
 * Obviously, an object doesn't have to implement X if it implements Y.
 * The naive solution is to create multiple collections for each type, and store potentially multiple duplicate references.
 *
 * Solution: Use reflection to allow querying through the metadata of the classes while keeping the objects
 * under a central single interface.
 */
public class MulticlassQuerier {

    private List<Queryable> queryables = new ArrayList<>();

    public void addQueryable(Queryable q) {
        this.queryables.add(q);
    }

    public <T> List<T> queryOfType(Class<T> type) {
        List<T> out = new ArrayList<>();
        for (Queryable q : queryables) {
            if (type.isAssignableFrom(q.getClass())) {
                out.add((T)q);
            }
        }
        return out;
    }
}
