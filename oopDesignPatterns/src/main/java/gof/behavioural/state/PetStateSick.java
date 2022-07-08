package gof.behavioural.state;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PetStateSick extends PetState {
    public PetStateSick(Pet pet) {
        super(pet);
    }
    @Override
    public void feed() {
        var config = PetStateConfig.getInstance();
        pet.addEnergy((int)(config.getFeedEnergyGain() * config.getFeedEnergyGainMultiplierSick()));
    }
    @Override
    public void sleep() {
        super.sleep();
        pet.setState(PetStateFactory.getPetState(PetStateNormal.class, pet));
    }
}
