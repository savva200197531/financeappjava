package ru.yandex.practicum;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws MyErrorClass, IOException, InterruptedException {
//        TestDate testDate = new TestDate();
        TestHttp testHttp = new TestHttp();

//        Predicate<String> x = (String text) -> Character.isUpperCase(text.charAt(0));
//
//        Predicate<String> y = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return Character.isUpperCase(s.charAt(0));
//            }
//        };
//
//        System.out.println(x.test("пРИВЕТ"));
//        System.out.println(y.test("ПРИВЕТ"));
//
//        Supplier<Double> randomSupplier = new Supplier<Double>() {
//            @Override
//            public Double get() {
//                return Math.random();
//            }
//        };
//
//        System.out.println(randomSupplier.get());
//
//        Shop shop = new Shop() {
//            @Override
//            public String getProductName() {
//                return super.getProductName();
//            }
//        };
//
//        System.out.println(shop.getProductName());
//
//        Person kostya = new Person("Костя", 5);
//
//        System.out.println(kostya.isOlderPredicate().test(new Person("Старше", 10)));
//
//        List<String> countries = new ArrayList<>(List.of(
//                "МЫВмы",
//                "asddasd",
//                "",
//                "dasdasdas",
//                ""
//        ));
//
//        List<String> countries2 = new ArrayList<>(List.of(
//                "МЫВмы",
//                "323",
//                "dasdasdas312",
//                ""
//        ));
//
//        countries.removeIf(name -> name.isEmpty());
//        countries.removeIf(String::isEmpty);
//        countries.removeIf(countries2::contains);
//        System.out.println(countries);
//
//        Function<Integer, ArrayList<Integer>> listCreator = ArrayList::new;
//
//        ArrayList<Integer> array = listCreator.apply(100);
//
//        System.out.println();
//
//        Stream<String> names = Stream.of("Арсений", "Иван", "Аня");
//
//        names.forEach(System.out::println);
//
//        List<String> nameList = List.of("Арсений", "Иван", "Аня");
//
//        Stream<String> namesStream = nameList.stream();
//
//        List<String> filteredNames = nameList.stream()
//                .filter(String::isEmpty)
//                .collect(Collectors.toList());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Predicate<Person> isOlderPredicate() {
        return person -> person.age > age;
    }
}

interface IProduct {
    void add();
    String getName();
}

class Shop {
    IProduct product;

    public String getProductName() {
        return "this.product.getName()";
    }
}

class Film implements Comparable<Film> {
    public String title;
    public String directorName;
    public int rating;

    public Film(String title, String directorName, int rating) {
        this.title = title;
        this.directorName = directorName;
        this.rating = rating;
    }

    @Override
    public int compareTo(Film o) {
        return o.rating - this.rating;
    }

    @Override
    public String toString() {
        return this.title + "\t" + this.directorName + "\t" + this.rating;
    }
}


class SomeClass implements Comparable<SomeClass> {
    int x = 10;
    int y = 20;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        return obj.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    public String toString() {
        return "y = " + y + ", x = " + x;
    }

    @Override
    public int compareTo(SomeClass o) {
        return this.x - o.x;
    }
}

class Address {
    private String street;
    private int number;
    public String city;
    public String[] residents;

    public void someMethod() throws MyErrorClass {
        throw new MyErrorClass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Arrays.equals(residents, address.residents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, city, Arrays.hashCode(residents));
    }
}


class MyErrorClass extends Exception {
    public MyErrorClass() {
    }

    public MyErrorClass(String message) {
        super(message);
    }

    public MyErrorClass(String message, Throwable cause) {
        super(message, cause);
    }

    public MyErrorClass(Throwable cause) {
        super(cause);
    }

    public MyErrorClass(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

@FunctionalInterface
interface StringSaverTransformer {
    String transform(String line);
}

@FunctionalInterface
interface StringSaverOnSaveListener {
    String transform(String line);
}

@FunctionalInterface
interface StringSaverOnRemoveListener {
    String transform(String line);
}

class StringSaver {
    private StringSaverTransformer transformer;
    private StringSaverOnSaveListener onSaveListener;
    private StringSaverOnRemoveListener onRemoveListener;

    public StringSaver(
            StringSaverTransformer transformer,
            StringSaverOnSaveListener onSaveListener,
            StringSaverOnRemoveListener onRemoveListener
    ) {
        this.transformer = transformer;
        this.onSaveListener = onSaveListener;
        this.onRemoveListener = onRemoveListener;
    }

    public void save(String line) {

    }
}

