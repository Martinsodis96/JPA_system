package se.soderstrand.martin.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "find all", query = "SELECT d FROM Employee d")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

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

    public Long getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }
}
