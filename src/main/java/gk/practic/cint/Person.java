package gk.practic.cint;

import java.math.BigDecimal;
import java.util.Optional;

public class Person {
    // mandatory
    private final String name;
    private final Integer age;
    // optional
    private final Optional<Double> heightMeters;

    public Person(String name, Integer age, Optional<Double> heightMeters) {
        this.validate(name, age);
        this.name = name == null ? "" : name;
        this.age = age;
        this.heightMeters = heightMeters;
    }

    private void validate(String name, Integer age) {

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Optional<Double> getHeightMeters() {
        return heightMeters;
    }
}
