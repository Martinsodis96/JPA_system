package se.soderstrand.martin.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries(value =
    @NamedQuery(name = "Department.GetAll", query = "SELECT d FROM Department d")
)
public class Department extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Collection<Employee> employees;

    protected Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
