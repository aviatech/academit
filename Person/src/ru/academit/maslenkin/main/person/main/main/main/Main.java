package ru.academit.maslenkin.main.person.main.main.main;

import ru.academit.maslenkin.main.person.main.main.person.Person;

import java.util.*;
import java.lang.String;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Александр on 19.11.2017.
 */


public class Main {
    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Ivan", 20));
        people.add(new Person("Jon", 28));
        people.add(new Person("Jack", 23));
        people.add(new Person("Pavel", 15));
        people.add(new Person("Pavel", 15));
        people.add(new Person("Pavel", 17));
        people.add(new Person("Petr", 17));
        people.add(new Person("Petr", 14));
        people.add(new Person("Anna", 48));

        List<String> names = people.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Имена " + names);

        System.out.println("Имена/средний возраст " + people.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge))));

        OptionalDouble age = people.stream().filter(x -> x.getAge() < 18)
                .mapToInt(Person::getAge)
                .average();
        System.out.println("Средний возраст людей младше 18= " + age.getAsDouble());

        Stream<Person> stream = people.stream()
                .filter(x -> x.getAge() >= 20 && x.getAge() <= 45)
                .sorted((y, z) -> y.getAge() - z.getAge());

        List<String> name = stream.map(Person::getName).collect(Collectors.toList());
        System.out.println(name);

    }
}
