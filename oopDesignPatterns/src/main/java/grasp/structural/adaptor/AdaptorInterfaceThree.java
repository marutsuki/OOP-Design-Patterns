package grasp.structural.adaptor;

import java.text.MessageFormat;

public class AdaptorInterfaceThree implements Adaptor {
    private IncompatibleInterfaceThree contained = new IncompatibleInterfaceThree();
    @Override
    public void greet() {
        contained.greet();
    }
}
