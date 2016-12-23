package net.vompi;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Johnny", "Boss", 9, false);
        Employee e2 = new Employee("Donny", "Manager", 5, true);
        Employee e3 = new Employee("Bonny", "HR", 12, true);
        Employee e4 = new Employee("Eonny", "Boss", 1, false);
        Employee e5 = new Employee("Hooneeny", "Boss", 90, false);

        CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        companyManagementSystem.addEmployee(e1);
        companyManagementSystem.addEmployees(employees);
        companyManagementSystem.removeEmployee(e4);

        System.out.println(companyManagementSystem.getEmployeesOfType("Boss").toString());
        System.out.println(companyManagementSystem.getEmployees().toString());
        System.out.println(companyManagementSystem.getEmployeesWithoutParkingSpace().toString());

    }
}
