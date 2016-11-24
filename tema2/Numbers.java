/**
* The Numbers program implements an application that
* finds the smallest number from a collection of numbers
* and displays it to standard output.
*
* @author  Avram Pop
* @version 0.1
* @since   2016-11-02
*/

public class Numbers {
  public static void main(String[] args){
    Numbers n = new Numbers();
    double numbers[] = {1, 2, 4, 5, -1, -6.55};
    double mini = n.smallestNumber(numbers);
    System.out.println(mini);
  }

  /**
    * Returns the smallest number from a collection of numbers
    *
    * @param  number[]  the collection of real numbers that has to be checked
    * @return    the smallest number from the given collection
    */

  public double smallestNumber(double numbers[]){
    double mini = numbers[0];
    for(int i = 1; i < numbers.length; i++){
      if(numbers[i] < mini) mini = numbers[i];
    }
    return mini;
  }
}
