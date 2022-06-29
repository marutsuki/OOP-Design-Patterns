package gof.structural.adaptor;

public class AdaptorInterfaceThree implements Adaptor {
    private IncompatibleInterfaceThree contained = new IncompatibleInterfaceThree();
    @Override
    public void greet() {
        contained.greet();
    }
}
