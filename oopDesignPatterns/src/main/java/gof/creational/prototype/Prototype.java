package gof.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Prototype {

    private Object mutableProperty;

    @Override
    public Prototype clone() {
        return new Prototype(this.mutableProperty);
    }
}
