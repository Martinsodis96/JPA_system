package se.soderstrand.martin.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity

@NamedQueries(value =
    @NamedQuery(name = "Employee.GetAll", query = "SELECT e FROM Employee e")
)
public class Employee extends AbstractEntity{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String employeeNumber;

    @ManyToOne
    private Department department;

    protected Employee() {
    }

    public Employee(String firstName, String lastName, String employeeNumber, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
}
