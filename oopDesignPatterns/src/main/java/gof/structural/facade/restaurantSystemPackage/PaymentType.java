package gof.structural.facade.restaurantSystemPackage;

import lombok.Getter;

@Getter
public enum PaymentType {
    CARD(0.03),
    CASH(0);
    private double taxMultiplier;
    PaymentType(double taxMultiplier) {
        this.taxMultiplier = taxMultiplier;
    }
}
