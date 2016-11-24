/**
* The Novel class extends from the Book class, and has one more member,
* the "type".
*
* @author  Avram Pop
* @version 0.1
*/

public class Novel extends Book {
  private String type;

  public Novel(String name, int numberOfPages, String type){
    super(name, numberOfPages);
    this.type = type;
  }

  public void printInfo(){
    System.out.println("Name: " + name);
    System.out.println("Number of pages: " + numberOfPages);
    System.out.println("Type: " + type);
  }
}
