/**
* The Book class is a base abstract class, containig
* basic information about this kind of objects. It contains a
* polymorphic method that prints every members' value.
*
* @author  Avram Pop
* @version 0.1
*/

public abstract class Book {
  protected String name;
  protected int numberOfPages;

  protected Book(String name, int numberOfPages){
    this.name = name;
    this.numberOfPages = numberOfPages;
  }

  /**
      * Prints the name, the number of pages and other characteristics
      * of the book this method is called on.
      */

  public abstract void printInfo();
}
