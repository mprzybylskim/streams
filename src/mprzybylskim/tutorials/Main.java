package mprzybylskim.tutorials;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        //filter every single female:
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

//        females.forEach(System.out::println);

        //sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
//        sorted.forEach(System.out::println);

        //all match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);
//        System.out.println(allMatch);

        //any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 100);
//        System.out.println(anyMatch);

        //any match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Greg House"));
//        System.out.println(noneMatch);

        //max
        people.stream()
                .max(Comparator.comparing(Person::getAge));
//        .ifPresent(System.out::println);

        //min
        people.stream()
                .min(Comparator.comparing(Person::getAge));
//                .ifPresent(System.out::println);

        //group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

//        groupByGender.forEach((gender, people1) -> {
//            System.out.println(gender);
//            people1.forEach(System.out::println);
//            System.out.println();
//        });

        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemale.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Greg House", 20, Gender.MALE),
                new Person("Lisa Cuddy", 19, Gender.FEMALE),
                new Person("James House", 23, Gender.MALE),
                new Person("James Wilson", 21, Gender.MALE),
                new Person("Anna Cook", 70, Gender.FEMALE),
                new Person("Robert Cook", 82, Gender.MALE),
                new Person("Greg Greggy", 16, Gender.MALE),
                new Person("Lisa House", 20, Gender.FEMALE)
        );
    }
}
