package gof.behavioural.strategy.strategies.aggregate;

import gof.behavioural.strategy.domain.Item;
import gof.behavioural.strategy.strategies.PriceCalculationStrategy;
import gof.behavioural.strategy.strategies.elementary.ElementaryPriceCalculationStrategy;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ConstantThresholdDiscountStrategy implements PriceCalculationStrategy {
    private double threshold;
    private ElementaryPriceCalculationStrategy strategy;
    @Override
    public double calculate(List<Item> items) {
        return items
                .stream()
                .map(i -> i.price() >= threshold ? strategy.calculateSingle(i) : i.price())
                .reduce(.0, Double::sum);
    }
}
