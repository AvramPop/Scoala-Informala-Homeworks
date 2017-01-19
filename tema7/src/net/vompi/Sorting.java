package net.vompi;

/**
 * Created by dani on 1/19/17.
 */
public class Sorting {

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
