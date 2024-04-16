package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.function.*;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       TODO:  1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message) {
        System.out.println(message);
        //Write your code here
        Predicate <Person> nameIsErik = person -> person.getFirstName().equalsIgnoreCase("Erik");
        List <Person> eriks = storage.findMany(nameIsErik);

        for (Person erik : eriks) {
            System.out.println(erik);
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  2.	Find all females in the collection using findMany().
    */
    public static void exercise2(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> isFemale = person -> person.getGender().equals(Gender.FEMALE);
        List<Person> females = storage.findMany(isFemale);

        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println(message);
        //Write your code here
        Predicate <Person> bornAfter2000 = person -> !person.getBirthDate().isBefore(LocalDate.parse("2000-01-01"));
        List <Person> bornAfter2000List = storage.findMany(bornAfter2000);

        for (Person person : bornAfter2000List) {
            System.out.println(person);
        }

        System.out.println("----------------------");
    }

    /*
        TODO: 4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);
        Predicate<Person> idIs123 = person -> person.getId() == 123;
        Person personWithId123 = storage.findOne(idIs123);

        if (personWithId123 != null) {
            System.out.println(personWithId123);
        } else {
            System.out.println("No person with id 123 found.");
        }

        System.out.println("----------------------");

    }

    /*
        TODO:  5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> idIs456 = person -> person.getId() == 456;
        Function<Person, String> personToString =  person ->
                "Name: " + person.getFirstName() + " " + person.getLastName() + " born " + person.getBirthDate();
        String personWithId456 = storage.findOneAndMapToString(idIs456, personToString);

        if (personWithId456 != null) {
            System.out.println(personWithId456);
        } else {
            System.out.println("No person with id 456 found.");
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> nameStartsWithE = person -> person.getFirstName().startsWith("E");
        Function<Person, String> personToString = person ->
                person.getFirstName() + " " + person.getLastName();
        List<String> namesStartsWithE = storage.findManyAndMapEachToString(nameStartsWithE, personToString);

        for (String name : namesStartsWithE) {
            System.out.println(name);
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> ageBelow10 = person -> LocalDate.now().getYear() - person.getBirthDate().getYear() < 10;
        Function<Person, String> personToString = person ->
                person.getFirstName() + " " + person.getLastName() + " " + (LocalDate.now().getYear()
                        - person.getBirthDate().getYear()) + " years";
        List<String> peopleBelow10 = storage.findManyAndMapEachToString(ageBelow10, personToString);

        for (String person : peopleBelow10) {
            System.out.println(person);
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> nameIsUlf = person -> person.getFirstName().equalsIgnoreCase("Ulf");
        Consumer<Person> printPerson = person -> System.out.println(person);
        storage.findAndDo(nameIsUlf, printPerson);

        System.out.println("----------------------");
    }

    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> lastNameContainsFirstName = person -> person.getLastName().contains(person.getFirstName());
        Consumer<Person> printPerson = person -> System.out.println(person);
        storage.findAndDo(lastNameContainsFirstName, printPerson);

        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> firstNameIsPalindrome = person -> new StringBuilder(person.getFirstName()).reverse().toString()
                .equalsIgnoreCase(person.getFirstName());
        Consumer<Person> printPerson = person -> System.out.println(person.getFirstName() + " " + person.getLastName());
        storage.findAndDo(firstNameIsPalindrome, printPerson);

        System.out.println("----------------------");
    }

    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }
}
