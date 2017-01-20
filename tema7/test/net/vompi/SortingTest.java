package net.vompi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dani on 1/19/17.
 */
public class SortingTest {
    @Test
    public void unsortedIntegerArrayIsSortedInAscendingOrder(){
        // given
        Integer [] array = new Integer []{9, 1, 2, 7 , 5, 6 , 3};
        Sorting s = new Sorting();
        // when
        Integer [] sortedArray;
        s.quicksort(array);
        sortedArray = array;
        // then
        Integer [] correctlySortedArray = new Integer[]{1,2,3,5,6,7,9};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test
    public void sortedIntegerArrayIsUnmodified(){
        // given
        Integer [] array = new Integer []{1,2,3,5,6,7,9};
        Sorting s = new Sorting();
        // when
        Integer [] sortedArray;
        s.quicksort(array);
        sortedArray = array;
        // then
        Integer [] correctlySortedArray = new Integer[]{1,2,3,5,6,7,9};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test
    public void unsortedIntegerArrayWithDuplicatesIsSorted(){
        // given
        Integer [] array = new Integer []{1,2,1,3,4,2,3,2,1};
        Sorting s = new Sorting();
        // when
        Integer [] sortedArray;
        s.quicksort(array);
        sortedArray = array;

        // then
        Integer [] correctlySortedArray = new Integer[]{1,1,1,2,2,2,3,3,4};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyArrayUsedOfIntegers_ExceptionIsThrown(){
        Integer [] array = new Integer [] {};
        Sorting s = new Sorting();
        s.quicksort(array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNullArrayUsedOfIntegers_ExceptionIsThrown(){
        Integer [] array = null;
        Sorting s = new Sorting();
        s.quicksort(array);
    }

    @Test
    public void unsortedStringArrayIsSortedInAscendingOrder(){
        // given
        String [] array = new String[]{"a", "c", "A", "B"};
        Sorting s = new Sorting();
        // when
        String [] sortedArray;
        s.quicksort(array);
        sortedArray = array;
        // then
        String [] correctlySortedArray = new String[]{"A", "B", "a", "c"};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test
    public void sortedStringArrayIsUnmodified(){
        // given
        String [] array = new String []{"A", "B", "a", "c"};
        Sorting s = new Sorting();
        // when
        String [] sortedArray;
        s.quicksort(array);
        sortedArray = array;
        // then
        String [] correctlySortedArray = new String[]{"A", "B", "a", "c"};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test
    public void unsortedStringArrayWithDuplicatesIsSorted(){
        // given
        String [] array = new String []{"c", "a", "B", "B", "A", "A"};
        Sorting s = new Sorting();
        // when
        String [] sortedArray;
        s.quicksort(array);
        sortedArray = array;

        // then
        String [] correctlySortedArray = new String[]{"A", "A", "B", "B", "a", "c"};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyArrayUsedOfStrings_ExceptionIsThrown(){
        String [] array = new String [] {};
        Sorting s = new Sorting();
        s.quicksort(array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNullArrayUsedOfStrings_ExceptionIsThrown(){
        String [] array = null;
        Sorting s = new Sorting();
        s.quicksort(array);
    }

    @Test
    public void unsortedPersonArrayIsSortedInAscendingOrder(){
        // given
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person [] array = new Person []{p3, p2, p1};
        Sorting s = new Sorting();
        // when
        Person [] sortedArray;
        s.quicksort(array);
        sortedArray = array;
        // then
        Person [] correctlySortedArray = new Person[]{p1, p2, p3};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test
    public void sortedPersonArrayIsUnmodified(){
        // given
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person [] array = new Person []{p1, p2, p3};
        Sorting s = new Sorting();
        // when
        Person [] sortedArray;
        s.quicksort(array);
        sortedArray = array;
        // then
        Person [] correctlySortedArray = new Person[]{p1, p2, p3};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test
    public void unsortedPersonArrayWithDuplicatesIsSorted(){
        // given
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person [] array = new Person []{p2, p3, p1, p1, p1, p2, p3};
        Sorting s = new Sorting();
        // when
        Person [] sortedArray;
        s.quicksort(array);
        sortedArray = array;

        // then
        Person [] correctlySortedArray = new Person[]{p1, p1, p1, p2, p2, p3, p3};
        Assert.assertArrayEquals(correctlySortedArray, sortedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyArrayUsedOfPerson_ExceptionIsThrown(){
        Person [] array = new Person [] {};
        Sorting s = new Sorting();
        s.quicksort(array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNullArrayUsedOfPerson_ExceptionIsThrown(){
        Person [] array = null;
        Sorting s = new Sorting();
        s.quicksort(array);
    }
}