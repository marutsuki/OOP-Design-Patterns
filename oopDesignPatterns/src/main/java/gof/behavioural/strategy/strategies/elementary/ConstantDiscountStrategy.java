package gof.behavioural.strategy.strategies.elementary;

import gof.behavioural.strategy.domain.Item;
import gof.behavioural.strategy.strategies.PriceCalculationStrategy;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ConstantDiscountStrategy implements PriceCalculationStrategy, ElementaryPriceCalculationStrategy {
    private double discount;
    @Override
    public double calculate(List<Item> items) {
        double preTotal = items
                .stream()
                .reduce(.0, (p, i) -> p + i.price(), Double::sum);

        return Math.max(0, preTotal - discount);
    }

    @Override
    public double calculateSingle(Item item) {
        return Math.max(0, item.price() - discount);
    }
}
