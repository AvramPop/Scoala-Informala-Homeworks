package net.vompi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>(Arrays.asList(new String [] {"John", "Flaviutu", "Danielu", "flaviutu"}));
        Collections.sort(name);
        System.out.println(name.toString());

        ArrayList<FBFriend> friends = new ArrayList<>();
        friends.add(new FBFriend("Johnny", 20, 58, 6));
        friends.add(new FBFriend("Fla", 20, 58, FBFriend.AGE_NOT_SPECIFIED));
        friends.add(new FBFriend("Sammy", 20, 58, 6));
        friends.add(new FBFriend("Jo", 20, 58, 6));

        Collections.sort(friends);
        System.out.println(friends.toString());
        Collections.sort(friends, ageComparator);
        System.out.println(friends.toString());
    }

    private static Comparator<FBFriend> ageComparator = new Comparator<FBFriend>() {
        @Override
        public int compare(FBFriend o1, FBFriend o2) {
            if (o1.getAge() == o2.getAge()) return 0;
            else if (o1.getAge() > o2.getAge()) return 1;
            else return -1;
        }
    };
}
