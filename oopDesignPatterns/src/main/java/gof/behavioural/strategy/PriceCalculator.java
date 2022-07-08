package gof.behavioural.strategy;

import gof.behavioural.strategy.domain.Item;
import gof.behavioural.strategy.strategies.PriceCalculationStrategy;
import gof.behavioural.strategy.strategies.elementary.RegularPriceStrategy;
import lombok.Setter;

import java.util.List;

@Setter
public class PriceCalculator {
    private PriceCalculationStrategy strategy = new RegularPriceStrategy();;

    public double calculatePrice(List<Item> items) {
        return strategy.calculate(items);
    }
}
