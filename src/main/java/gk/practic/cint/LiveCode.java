package gk.practic.cint;


import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class LiveCode {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Peter", 25, Optional.of(1.81)),
                new Person("Ana", 40, Optional.of(1.64)),
                new Person("Paul", 12, Optional.empty())
        );
        printAllPerson(personList, LiveCode::printPersonInfo);
        // personList.add(new Person("A", 12, Optional.empty()));
    }

    public static void printPersonInfo(Person person) {
        System.out.println("Person: name: " + person.getName() +
                " and age:" + person.getAge());
//        String.format("MM");

    }

    public static void printAllPerson(Collection<Person> collection, Consumer<Person> consumer) {
        collection.forEach(consumer);

    }
}
