package gof.behavioural.state;

public abstract class PetState {
    protected Pet pet;
    private final PetStateConfig config = PetStateConfig.getInstance();
    public PetState(Pet pet) {
        this.pet = pet;
    }
    public void feed() {
        pet.addEnergy(config.getFeedEnergyGain());
    }

    public void walk() {
        pet.addEnergy(-config.getExerciseEnergyLoss());
    }

    public void sleep() {
        pet.addEnergy(config.getSleepEnergyGain());
    }
}
