package gof.behavioural.strategy.strategies.elementary;

import gof.behavioural.strategy.domain.Item;
import gof.behavioural.strategy.strategies.PriceCalculationStrategy;

import java.util.List;

public class RegularPriceStrategy implements PriceCalculationStrategy, ElementaryPriceCalculationStrategy {

    @Override
    public double calculate(List<Item> items) {
        return items
                .stream()
                .reduce(.0, (p, i) -> p + i.price(), Double::sum);
    }

    @Override
    public double calculateSingle(Item item) {
        return item.price();
    }
}
