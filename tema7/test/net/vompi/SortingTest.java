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
    public void whenEmptyArrayUsed_ExceptionIsThrown(){
        Integer [] array = new Integer [] {};
        Sorting s = new Sorting();
        s.quicksort(array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNullArrayUsed_ExceptionIsThrown(){
        Integer [] array = null;
        Sorting s = new Sorting();
        s.quicksort(array);
    }
}