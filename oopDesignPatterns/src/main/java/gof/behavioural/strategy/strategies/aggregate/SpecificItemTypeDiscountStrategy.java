package gof.behavioural.strategy.strategies.aggregate;

import gof.behavioural.strategy.domain.Item;
import gof.behavioural.strategy.domain.ItemType;
import gof.behavioural.strategy.strategies.PriceCalculationStrategy;
import gof.behavioural.strategy.strategies.elementary.ElementaryPriceCalculationStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SpecificItemTypeDiscountStrategy implements PriceCalculationStrategy {
    private Set<ItemType> types = new TreeSet<>();
    private ElementaryPriceCalculationStrategy strategy;
    public SpecificItemTypeDiscountStrategy(ElementaryPriceCalculationStrategy strategy, ItemType... types) {
        this.strategy = strategy;
        this.types.addAll(Arrays.asList(types));
    }
    @Override
    public double calculate(List<Item> items) {
        return items
                .stream()
                .map(i -> types.contains(i.type()) ? strategy.calculateSingle(i) : i.price())
                .reduce(.0, Double::sum);
    }
}
