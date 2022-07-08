package gof.behavioural.state;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PetStateHungry extends PetState {
    public PetStateHungry(Pet pet) {
        super(pet);
    }
    @Override
    public void feed() {
        log.info("Your pet violently eats up all the food");
        super.feed();
        if (pet.getEnergy() > PetStateConfig.getInstance().getPetHungryStateThreshold()) {
            pet.setState(PetStateFactory.getPetState(PetStateNormal.class, pet));
        }
    }
    @Override
    public void walk() {
        var config = PetStateConfig.getInstance();
        log.info("Your pet feels like it's about to faint");
        pet.addEnergy(-(int)(config.getExerciseEnergyLoss() * config.getExerciseEnergyLossMultiplier()));
    }
}
