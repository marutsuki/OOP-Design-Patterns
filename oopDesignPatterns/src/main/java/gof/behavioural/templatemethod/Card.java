package gof.behavioural.templatemethod;

import java.util.function.Consumer;

enum CardType {
    MONSTER,
    SPELL
}

/**
 * This is an example dataclass and may not be suitable for a realistic card game system
 */
public record Card(String name, CardType type) {}
