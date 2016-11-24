/**
* The Primes program implements an application that
* calculates the prime numbers below a given number
* and displays them to the standard output.
*
* @author  Avram Pop
* @version 0.1
* @since   2016-11-02
*/

public class Primes {
  public static void main(String[] args){
    Primes p = new Primes();
    p.primeNumbersBelow(300);
  }

  /**
    * Displays the prime numbers below a given limit
    *
    * @param  limit  the number up to which the primes have to be computed
    */

  public void primeNumbersBelow(int limit){
    if(limit < 2){
       System.out.println("There's no prime number below 2");
    } else {
        System.out.println("2");
        Primes p = new Primes();
        for(int i = 3; i <= limit; i += 2){
          if(p.isPrime(i)) System.out.println(i);
        }
      }
  }

  /**
    * Checks if the given number is prime
    *
    * @param  number  the number up to which the sum has to be computed
    * @return    the validity of the logical sentence "number is prime"
    */

  public boolean isPrime(int number){
    for(int i = 3; i <= Math.sqrt(number); i += 2){
      if(number % i == 0) return false;
    }
    return true;
  }

}
