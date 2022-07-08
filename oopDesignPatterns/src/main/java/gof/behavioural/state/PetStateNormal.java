package gof.behavioural.state;

public class PetStateNormal extends PetState {
    public PetStateNormal(Pet pet) {
        super(pet);
    }
    @Override
    public void feed() {
        super.feed();
        if (pet.getEnergy() > PetStateConfig.getInstance().getPetNormalStateThreshold()) {
            pet.setState(PetStateFactory.getPetState(PetStateEnergetic.class, pet));
        }
    }
    @Override
    public void walk() {
        super.walk();
        if (pet.getEnergy() < PetStateConfig.getInstance().getPetHungryStateThreshold()) {
            pet.setState(PetStateFactory.getPetState(PetStateHungry.class, pet));
        }
    }
    @Override
    public void sleep() {
        super.sleep();
        pet.setState(PetStateFactory.getPetState(PetStateEnergetic.class, pet));
    }
}
