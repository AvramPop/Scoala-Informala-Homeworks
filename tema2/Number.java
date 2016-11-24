/**
* The Number program implements an application that
* finds the maximum digit of a given number
* and displays it to standard output.
*
* @author  Avram Pop
* @version 0.1
* @since   2016-11-02
*/

public class Number {
  public static void main(String[] args){
    Number n = new Number();
    System.out.println(n.maximumDigit(5899963));
  }

  /**
    * Returns the maximum digit of a given number
    *
    * @param  number  the number which maximum digit has to be computed
    * @return    the maximum digit of the given number
    */

  public int maximumDigit(int number){
    int c = -1;
    while(number > 0){
      if(number % 10 > c) c = number % 10;
      number = number / 10;
    }
    return c;
  }

}
