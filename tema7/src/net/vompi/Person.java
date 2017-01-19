package net.vompi;

import java.util.Objects;

/**
 * Created by dani on 1/19/17.
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
