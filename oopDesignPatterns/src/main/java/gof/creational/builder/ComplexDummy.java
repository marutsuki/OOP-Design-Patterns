package gof.creational.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplexDummy {
    private List<Object> listOfObjects = new ArrayList<>();
    private Map<Object, Object> mapOfObjects = new HashMap<>();
    private Object property = null;
    private String name = null;
}
