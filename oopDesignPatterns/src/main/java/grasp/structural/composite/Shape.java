package grasp.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Shape {
    private double x = 0;
    private double y = 0;
    public abstract double calculateArea();
    public abstract void render();
}
