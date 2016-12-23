package net.vompi;
/**
 * The Employee class simulates an employee who has a name, a type(eg. position),
 * a number of years spent in the company, and can have a parking space
 *
 * It can update any of its informations.
 *
 * The class implements the Comparable interface, so a Employee
 * can be compared with another one. The objects are sorted by
 * their amount of years spent in the company
 */
public class Employee implements Comparable<Employee> {
    private String type;
    private int yearsSpentInCompany;
    private boolean hasParkingSpace;
    private String name;

    public Employee(String name, String type, int yearsSpentInCompany, boolean hasParkingSpace) {
        this.name = name;
        this.type = type;
        this.yearsSpentInCompany = yearsSpentInCompany;
        this.hasParkingSpace = hasParkingSpace;
    }

    public String getType(){
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getYearsSpentInCompany() {
        return yearsSpentInCompany;
    }

    public void setYearsSpentInCompany(int yearsSpentInCompany) {
        this.yearsSpentInCompany = yearsSpentInCompany;
    }

    public boolean hasParkingSpace() {
        return hasParkingSpace;
    }

    public void setHasParkingSpace(boolean hasParkingSpace) {
        this.hasParkingSpace = hasParkingSpace;
    }

    /**
     * The compareTo method compares two Employees according to their
     * years spent in company. The one who is older will go first.
     * @param e the Employee to compare the actual object with
     * @return -1 if the actual object is older in the company, 1 otherwise
     */

    @Override
    public int compareTo(Employee e) {
        if(this.yearsSpentInCompany > e.getYearsSpentInCompany()) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", yearsSpentInCompany=" + yearsSpentInCompany +
                ", hasParkingSpace=" + hasParkingSpace +
                '}' + '\n';
    }
}
