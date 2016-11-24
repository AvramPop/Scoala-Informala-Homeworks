import java.util.ArrayList;

/**
* The Library program implements an application that
* holds a collection of books, and manages(add, delete, list) them.
*
* @author  Avram Pop
* @version 0.1
*/

public class Library {
  public static void main(String[] args){

    Library lib = new Library();

    Album book1 = new Album("Family", 100, "high");
    Album book2 = new Album("Friends", 25, "low");
    Novel book3 = new Novel("Saga", 200, "SF");

    lib.addBook(book1);
    lib.addBook(book2);
    lib.listBooks();
    lib.deleteBook(book2);
    lib.listBooks();
    lib.addBook(book3);
    lib.listBooks();
  }

ArrayList<Book> books = new ArrayList<Book>();

  /**
      * Prints the information of every book in the library.
      */

  public void listBooks() {
    for(Book b : books) {
      b.printInfo();
    }
    System.out.println();
  }

  /**
      * Adds a new book to the Library's list of books.
      *
      * @param newBook the book to be added in the collection
      */

  public void addBook(Book newBook) {
    books.add(newBook);
  }

  /**
      * Removes a certain book from the Library's list of books.
      *
      * @param bookToRemove the book to be removed from the collection
      */

  public void deleteBook(Book bookToRemove) {
    books.remove(bookToRemove);
  }
}
