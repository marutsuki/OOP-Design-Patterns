package gof.behavioural.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IntruderActivityContext implements Context {
    private double presenceLevel;
    private String message;
}
