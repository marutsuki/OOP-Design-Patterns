package grasp.structural.adaptor;

import java.text.MessageFormat;

public class AdaptorInterfaceTwo implements Adaptor {
    private IncompatibleInterfaceTwo contained = new IncompatibleInterfaceTwo();
    @Override
    public void greet() {
        String name = contained.getClass().getSimpleName();
        contained.log(String.format("%s just waved!", name), String.format("%s says: Hello there", name));
    }
}
