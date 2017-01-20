package net.vompi;

import java.util.Objects;

/**
 * A class created just for testing purposes which implements the Comaparable inteface,
 * which has a single member, the age, which is used for comparing means.
 */
public class Person implements Comparable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.getAge();
    }
}
