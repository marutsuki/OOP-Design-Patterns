package gof.behavioural.strategy.strategies;

import gof.behavioural.strategy.domain.Item;

import java.util.List;

public interface PriceCalculationStrategy {
    double calculate(List<Item> items);
}
