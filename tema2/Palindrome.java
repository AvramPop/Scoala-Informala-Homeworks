/**
* The Palindrome program implements an application that
* checks if a given number is palindrome (eg. 121, 32523).
*
* @author  Avram Pop
* @version 0.1
* @since   2016-11-02
*/

public class Palindrome {
  public static void main(String[] args){
    Palindrome p = new Palindrome();
    System.out.println(p.isPalindrome(232));
  }

  /**
    * Checks if the given number is a palindrome
    *
    * @param  number  the number which has to be checked
    * @return    the validity of the logical sentence "number is palindrome"
    */

  public boolean isPalindrome(int number){
    int copy = number, newNumber = 0;
    while(copy > 0) {
      newNumber = newNumber * 10 + copy % 10;
      copy = copy / 10;
    }
    if(newNumber == number) return true;
    return false;
  }

}
