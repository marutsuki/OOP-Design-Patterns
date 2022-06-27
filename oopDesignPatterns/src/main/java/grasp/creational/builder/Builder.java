package grasp.creational.builder;

/**
 * Pattern name: Builder
 *
 * Problem: How do we effectively manage complex creation logic where we want to give the user the flexibility on how
 * the object is created? That is, allow the user to tweak certain fields while in full control on how the object is built?
 *
 * The naive solution would be to create a constructor for each possible combination or logic
 *
 * Solution: Create a helper builder class that holds a partially completed target object, and expose methods that allow the user to
 * change the target object until they are done.
 *
 * A code friendly way of making a builder involves returning the builder itself so that methods can be continuously chained.
 */
public class Builder {

    public BuilderIntermediate init() {
        return new BuilderIntermediate();
    }

    /**
     * Note that we use an intermediate builder class. We don't want to use the original Builder class to control the entire construction.
     * What if we call init() and then init() again before calling build()? We would be throwing away the original object. To manage this redundancy.
     * We implement the only way to start building is through the original Builder, and the only way building can continue is through the IntermediateBuilder
     */
    protected class BuilderIntermediate {
        private ComplexDummy dummy;

        public BuilderIntermediate() {
            this.dummy = new ComplexDummy();
        }

        public BuilderIntermediate addToList(Object o) {
            this.dummy.getListOfObjects().add(o);
            return this;
        }

        public BuilderIntermediate addMapping(Object key, Object value) {
            this.dummy.getMapOfObjects().put(key, value);
            return this;
        }

        public BuilderIntermediate changeName(String name) {
            this.dummy.setName(name);
            return this;
        }

        public BuilderIntermediate setProperty(Object property) {
            this.dummy.setProperty(property);
            return this;
        }

        /**
         * Finalizing method to build the ComplexDummy
         * @return ComplexDummy
         */
        public ComplexDummy build() {
            return this.dummy;
        }
    }
}
