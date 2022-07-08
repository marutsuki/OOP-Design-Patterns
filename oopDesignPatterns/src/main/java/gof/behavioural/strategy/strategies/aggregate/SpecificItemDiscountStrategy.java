package gof.behavioural.strategy.strategies.aggregate;

import gof.behavioural.strategy.domain.Item;
import gof.behavioural.strategy.strategies.PriceCalculationStrategy;
import gof.behavioural.strategy.strategies.elementary.ElementaryPriceCalculationStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SpecificItemDiscountStrategy implements PriceCalculationStrategy {
    private Set<Item> items = new TreeSet<>();
    private ElementaryPriceCalculationStrategy strategy;

    public SpecificItemDiscountStrategy(ElementaryPriceCalculationStrategy strategy, Item... items) {
        this.strategy = strategy;
        this.items.addAll(Arrays.asList(items));
    }

    @Override
    public double calculate(List<Item> items) {
        return items
                .stream()
                .map(i -> items.contains(i) ? strategy.calculateSingle(i) : i.price())
                .reduce(.0, Double::sum);
    }
}
