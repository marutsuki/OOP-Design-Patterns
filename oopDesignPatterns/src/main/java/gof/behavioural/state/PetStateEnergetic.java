package gof.behavioural.state;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PetStateEnergetic extends PetState {
    public PetStateEnergetic(Pet pet) {
        super(pet);
    }
    @Override
    public void walk() {
        super.walk();
        if (pet.getEnergy() < PetStateConfig.getInstance().getPetNormalStateThreshold()) {
            pet.setState(PetStateFactory.getPetState(PetStateNormal.class, pet));
        }
    }
    @Override
    public void sleep() {
        log.info("Your pet won't sleep, he's too energetic!");
    }
}
