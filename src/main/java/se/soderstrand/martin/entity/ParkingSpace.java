package se.soderstrand.martin.entity;

import javax.persistence.*;

@Entity
@NamedQueries(value =
    @NamedQuery(name = "ParkingSpace.GetAll", query = "SELECT ps FROM ParkingSpace ps")
)
public class ParkingSpace extends AbstractEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @ManyToOne
    private Employee employee;

    protected ParkingSpace() {
    }

    public ParkingSpace(String label, Employee employee) {
        this.label = label;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getLabel() {
        return label;
    }
}
