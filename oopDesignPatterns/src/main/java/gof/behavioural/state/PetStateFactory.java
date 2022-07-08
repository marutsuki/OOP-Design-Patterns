package gof.behavioural.state;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class PetStateFactory {
    private static Map<Class<? extends PetState>, PetState> stateMap;
    public static PetState getPetState(Class<? extends PetState> type, Pet pet) {
        var state = stateMap.get(type);
        if (state == null) {
            try {
                state = type.getConstructor(Pet.class).newInstance(pet);
                stateMap.put(type, state);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                return new PetStateNull(pet);
            }

        }
        return state;
    }
}
