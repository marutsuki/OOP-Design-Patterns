package util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<T1, T2> {
    private T1 t1;
    private T2 t2;
}
