/**
* The Sum program implements an application that
* calculates the sum of the first N natural numbers
* and displays it to the standard output.
*
* @author  Avram Pop
* @version 0.1
* @since   2016-11-02
*/

public class Sum {
  public static void main(String[] args){
    Sum sum = new Sum();
    int s;
    s = sum.gaussSum(100);
    System.out.println(s);
  }

 /**
   * Returns an integer which represents the sum of the first N natural
   * numbers greater than 0 using the Gauss sum.
   *
   * @param  N  the number up to which the sum has to be computed
   * @return    the sum of the first N numbers
   */

  public int gaussSum(int N){
    return N * (N + 1) / 2;
  }
}
