package net.vompi;

public class Main {

    public static void main(String[] args) {
	    Sorting s = new Sorting();
	    Integer [] arr = {1,2,1,3, 4, 2 , 3, 2, 1};
	    String [] strArr = {"dani", "Dani", "POp", "AbcA"};
        Person p1 = new Person(5);
        Person p2 = new Person(9);
        Person p3 = new Person(1222);
	    Person [] persArr = {p1, p2, p3};
	    persArr[0] = p1;
	    persArr[1] = p2;
	    persArr[2] = p3;
	    s.quicksort(arr);
	    s.quicksort(strArr);
	    s.quicksort(persArr);
	    for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        for(int i = 0; i < strArr.length; i++){
            System.out.println(strArr[i]);
        }
        for(int i = 0; i < persArr.length; i++){
            System.out.println(persArr[i].getAge());
        }
    }
}
