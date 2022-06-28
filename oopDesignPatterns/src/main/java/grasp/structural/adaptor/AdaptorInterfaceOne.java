package grasp.structural.adaptor;

public class AdaptorInterfaceOne implements Adaptor {
    private IncompatibleInterfaceOne contained = new IncompatibleInterfaceOne();
    @Override
    public void greet() {
        contained.waveHand();
        contained.saySomething("Hello there");
    }
}
