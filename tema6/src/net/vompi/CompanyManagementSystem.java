package net.vompi;

import java.util.*;

/**
 * The CompanyManagementSystem class simulates a management system of a company's employees.
 *
 * It can add and remove employees from its database, and give
 * responses for certain interrogations.
 */

public class CompanyManagementSystem {
    private Map<String, Set<Employee>> employees = new HashMap<>();
    private Set<Employee> employeesWithoutParkingSpace = new TreeSet<>();

    /**
     * The addEmployees receives a list of employees and adds every single one
     * in his according type's collection.
     * @param employeesListToAdd The list to be added
     * @throws IllegalArgumentException if the employeesListToAdd is null
     */

    public void addEmployees(ArrayList<Employee> employeesListToAdd) throws IllegalArgumentException{
        if(employeesListToAdd == null){
            throw new IllegalArgumentException("The employees list should not be null");
        }
        for(Employee e : employeesListToAdd){
            addToEmployeesMap(e);
            addToWithoutParkingEmployeesSet(e);
        }
    }

    /**
     * The addEmployee receives an employee and adds it
     * in his according type's collection
     * @param employeeToAdd the employee to add
     * @throws IllegalArgumentException if employeeToAdd is null
     */

    public void addEmployee(Employee employeeToAdd) throws IllegalArgumentException{
        if(employeeToAdd == null){
            throw new IllegalArgumentException("The employee should not be null");
        }
        addToEmployeesMap(employeeToAdd);
        addToWithoutParkingEmployeesSet(employeeToAdd);
    }

    /**
     * Removes an employee from database
     * @param employeeToRemove the employee to remove
     * @throws IllegalArgumentException if the employeeToRemove is not in the database
     */

    public void removeEmployee(Employee employeeToRemove) throws IllegalArgumentException{
        if(this.employees.get(employeeToRemove.getType()).contains(employeeToRemove)){
            this.employees.get(employeeToRemove.getType()).remove(employeeToRemove);
        } else {
            throw new IllegalArgumentException("This employee does not belong to your database");
        }
    }

    private void addToWithoutParkingEmployeesSet(Employee employee){
        if(!employee.hasParkingSpace()){
            employeesWithoutParkingSpace.add(employee);
        }
    }

    private void addToEmployeesMap(Employee employee){
        Set<Employee> s = new HashSet<>();
        String employeeType = employee.getType();
        if(this.employees.containsKey(employeeType)) {
            s = this.employees.get(employeeType);
        }
        s.add(employee);
        this.employees.put(employee.getType(), s);
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employeesList = new ArrayList<>();
        for (Map.Entry<String, Set<Employee>> entry : employees.entrySet()) {
            employeesList.addAll(entry.getValue());
        }
        return employeesList;
    }

    /**
     * The getEmployeesOfType method returns a list of employees of the asked type
     * @param type the type of the employees to receive
     * @return a list of employees of asked type
     * @throws IllegalArgumentException if there is no employee of asked type
     */

    public ArrayList<Employee> getEmployeesOfType(String type) throws IllegalArgumentException{
        if(this.employees.containsKey(type)) {
            ArrayList<Employee> e = new ArrayList<>();
            e.addAll(this.employees.get(type));
            return e;
        } else {
            throw new IllegalArgumentException("No employee with this type");
        }
    }

    /**
     * The getEmployeesWithoutParkingSpace returns a list of all the employees in the database
     * who do not have a parking space assigned.
     * @return the list of employees without a parking space
     */

    public ArrayList<Employee> getEmployeesWithoutParkingSpace() {
        ArrayList<Employee> e = new ArrayList<>();
        e.addAll(this.employeesWithoutParkingSpace);
        return e;
    }

 }

