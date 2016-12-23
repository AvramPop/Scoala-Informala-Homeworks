package net.vompi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by dani on 12/23/16.
 */
public class CompanyManagementSystemTest {
    @Test
    public void ManagementSystemCorrectlySortsEmployeesListWithoutParkingSpace(){
        // given
        Employee e1 = new Employee("a", "b", 5, false);
        Employee e2 = new Employee("a", "b", 6, false);
        Employee e3 = new Employee("a", "b", 60, true);
        ArrayList<Employee> employeesList = new ArrayList<>();
        employeesList.add(e1);
        employeesList.add(e2);
        employeesList.add(e3);
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        // when
        companyManagementSystem.addEmployees(employeesList);
        employeesList = companyManagementSystem.getEmployeesWithoutParkingSpace();
        // then
        ArrayList<Employee> correctlySortedListOfEmployeesWithoutParkingSpaces = new ArrayList<>();
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e2);
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e1);
        Assert.assertEquals(employeesList, correctlySortedListOfEmployeesWithoutParkingSpaces);
    }

    @Test
    public void ManagementSystemCorrectlySortsEmployeesAddedOneAfterAnotherWithoutParkingSpace(){
        // given
        Employee e1 = new Employee("a", "b", 5, false);
        Employee e2 = new Employee("a", "b", 6, false);
        Employee e3 = new Employee("a", "b", 60, true);
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        ArrayList<Employee> employeesList;
        // when
        companyManagementSystem.addEmployee(e1);
        companyManagementSystem.addEmployee(e2);
        companyManagementSystem.addEmployee(e3);
        employeesList = companyManagementSystem.getEmployeesWithoutParkingSpace();
        // then
        ArrayList<Employee> correctlySortedListOfEmployeesWithoutParkingSpaces = new ArrayList<>();
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e2);
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e1);
        Assert.assertEquals(employeesList, correctlySortedListOfEmployeesWithoutParkingSpaces);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NullListOfEmployeesThrowsException_WhenPassedToTheSystem(){
        // given
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        ArrayList<Employee> employeesList = null;
        // when
        companyManagementSystem.addEmployees(employeesList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NullEmployeeThrowsException_WhenPassedToTheSystem(){
        // given
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        Employee nullEmployee = null;
        // when
        companyManagementSystem.addEmployee(nullEmployee);
    }

    @Test
    public void ManagementSystemCorrectlyRemovesEmployee(){
        // given
        Employee e1 = new Employee("a", "b", 5, false);
        Employee e2 = new Employee("a", "b", 6, false);
        Employee e3 = new Employee("a", "b", 60, true);
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        ArrayList<Employee> employeesList;
        // when
        companyManagementSystem.addEmployee(e1);
        companyManagementSystem.addEmployee(e2);
        companyManagementSystem.addEmployee(e3);
        companyManagementSystem.removeEmployee(e3);
        employeesList = companyManagementSystem.getEmployees();
        // then
        ArrayList<Employee> correctlySortedListOfEmployeesWithoutParkingSpaces = new ArrayList<>();
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e2);
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e1);
        Assert.assertEquals(employeesList, correctlySortedListOfEmployeesWithoutParkingSpaces);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ManagementSystemThrowsExceptionWhenEmployeeWhichIsNotInTheDBHasToBeRemoved(){
        // given
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        Employee e1 = new Employee("asd", "sad", 5, false);
        Employee e2 = new Employee("asd", "sad", 5, false);
        // when
        companyManagementSystem.addEmployee(e1);
        companyManagementSystem.removeEmployee(e2);
    }

    @Test
    public void ManagementSystemCorrectlyRespondsWithListOfEmployeesOfRequestedType(){
        // given
        Employee e1 = new Employee("a", "b", 5, false);
        Employee e2 = new Employee("a", "c", 6, false);
        Employee e3 = new Employee("a", "b", 60, true);
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        ArrayList<Employee> employeesList;
        // when
        companyManagementSystem.addEmployee(e1);
        companyManagementSystem.addEmployee(e2);
        companyManagementSystem.addEmployee(e3);
        employeesList = companyManagementSystem.getEmployeesOfType("b");
        // then
        ArrayList<Employee> correctlySortedListOfEmployeesWithoutParkingSpaces = new ArrayList<>();
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e1);
        correctlySortedListOfEmployeesWithoutParkingSpaces.add(e3);
        Assert.assertEquals(employeesList, correctlySortedListOfEmployeesWithoutParkingSpaces);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ManagementSystemThrowsExceptionWhenListOfEmployeesOfRequestedTypeIsNotInTheDB(){
        // given
        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
        Employee e1 = new Employee("asd", "a", 5, false);
        Employee e2 = new Employee("asd", "b", 5, false);
        // when
        companyManagementSystem.getEmployeesOfType("d");
    }
}