package gof.behavioural.state;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {
    private int energy = 100;
    private PetState state = new PetStateNormal(this);

    public void addEnergy(int value) {
        this.energy += value;
    }
    public void feed() {
        state.feed();
    }
    public void walk() {
        state.walk();
    }
    public void sleep() {
        state.sleep();
    }
}
