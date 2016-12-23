package net.vompi;

import java.util.Comparator;

/**
 * Created by dani on 12/20/16.
 */
public class FBFriend implements Comparable<FBFriend>{
    public static final int AGE_NOT_SPECIFIED = 0;

    private String name;
    private int numberOfPhotos;
    private int numberOfFriends;
    private int age;

    public FBFriend(String name, int numberOfPhotos, int numberOfFriends, int age) {
        this.name = name;
        this.numberOfPhotos = numberOfPhotos;
        this.numberOfFriends = numberOfFriends;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public int getNumberOfFriends() {
        return numberOfFriends;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(FBFriend other){
        return name.compareTo(other.getName());
    }
}
