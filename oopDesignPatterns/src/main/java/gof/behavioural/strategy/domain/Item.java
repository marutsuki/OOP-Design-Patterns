package gof.behavioural.strategy.domain;

import java.util.Objects;

public record Item(String name, double price, ItemType type) {
    public Item {
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(type);
    }

    public Item(String name, double price) {
        this(name, price, ItemType.NORMAL);
    }
}
