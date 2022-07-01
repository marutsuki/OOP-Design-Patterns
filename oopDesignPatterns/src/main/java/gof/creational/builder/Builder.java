package gof.creational.builder;

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
