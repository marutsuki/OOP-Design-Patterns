package gof.behavioural.strategy.strategies.elementary;

import gof.behavioural.strategy.domain.Item;
import gof.behavioural.strategy.strategies.PriceCalculationStrategy;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PercentageDiscountStrategy implements PriceCalculationStrategy, ElementaryPriceCalculationStrategy {
    private double discountPercentage;
    @Override
    public double calculate(List<Item> items) {
        double preTotal = items
                .stream()
                .reduce(.0, (p, i) -> p + i.price(), Double::sum);
        return preTotal * Math.max(0, (1 - discountPercentage));
    }

    @Override
    public double calculateSingle(Item item) {
        return item.price() * Math.max(0, (1 - discountPercentage));
    }
}
