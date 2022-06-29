package util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quadtriplet<T1, T2, T3, T4> {
    private T1 t1;
    private T2 t2;
    private T3 t3;
    private T4 t4;
}
