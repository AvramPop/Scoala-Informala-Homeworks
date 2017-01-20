package net.vompi;

/**
 * The Sorting class offers a lot of useful generic array-sorting methods
 */
public class Sorting {

    /**
     * The quicksort method sorts a given array of objects in ascending order,
     * according to every object's comparing rule, using the quicksort algorithm,
     * as described on <a href>https://en.wikipedia.org/wiki/Quicksort</a>
     *
     * @param arrayToSort the array of objects to sort
     * @param <T> any class which implements the Comparable interface on objects of same kind
     */

    public <T extends Comparable<T>> void quicksort(T[] arrayToSort){
        if (arrayToSort == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }
        if (arrayToSort.length == 0) {
            throw new IllegalArgumentException("Array must not be empty.");
        }
        quicksort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private <T extends Comparable<T>> void quicksort(T[] arrayToSort, int lo, int hi){
        if(lo < hi){
            int p = partition(arrayToSort, lo, hi);
            quicksort(arrayToSort, lo, p - 1);
            quicksort(arrayToSort, p + 1, hi);
        }
    }

    private <T extends Comparable<T>> int partition(T[] arrayToSort, int lo, int hi){
        T pivot = arrayToSort[hi];
        int i = lo;
        T temp;
        for(int j = lo; j <= hi - 1; j++){
            if(arrayToSort[j].compareTo(pivot) < 0){
                temp = arrayToSort[i];
                arrayToSort[i] = arrayToSort[j];
                arrayToSort[j] = temp;
                i++;
            }
        }
        temp = arrayToSort[i];
        arrayToSort[i] = arrayToSort[hi];
        arrayToSort[hi] = temp;
        return i;
    }
}
