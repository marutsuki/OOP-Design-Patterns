package gof.behavioural.state;

import lombok.Getter;

@Getter
public class PetStateConfig {
    private static final PetStateConfig instance = new PetStateConfig();
    private final int sleepEnergyGain = 100;
    private final int feedEnergyGain = 50;
    private final int exerciseEnergyLoss = 20;
    private final int petNormalStateThreshold = 100;
    private final int petHungryStateThreshold = 75;
    private final double exerciseEnergyLossMultiplier = 1.5;
    private final double feedEnergyGainMultiplierSick = 0.5;
    private PetStateConfig() {}
    public static PetStateConfig getInstance() {
        return instance;
    }
}
