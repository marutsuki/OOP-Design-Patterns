package gof.behavioural.strategy.strategies.elementary;

import gof.behavioural.strategy.domain.Item;

public interface ElementaryPriceCalculationStrategy {
    double calculateSingle(Item item);
}
