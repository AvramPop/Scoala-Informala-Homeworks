/**
* The Album class extends from the Book class, and has one more member,
* the "paperQuality".
*
* @author  Avram Pop
* @version 0.1
*/

public class Album extends Book {
  private String paperQuality;

  public Album(String name, int numberOfPages, String paperQuality){
    super(name, numberOfPages);
    this.paperQuality = paperQuality;
  }

  public void printInfo() {
    System.out.println("Name: " + name);
    System.out.println("Number of pages: " + numberOfPages);
    System.out.println("Paper quality: " + paperQuality);
  }
}
