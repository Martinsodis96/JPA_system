package se.soderstrand.martin.repository.jpa;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.EmployeeRepository;
import se.soderstrand.martin.repository.crud.BaseRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

import static java.util.function.UnaryOperator.identity;

/**
 * Created by Martin on 2016-10-25.
 */
public final class JpaEmployeeRepository extends BaseRepository<Employee> implements EmployeeRepository{

    public JpaEmployeeRepository(EntityManagerFactory factory) {
        super(Employee.class, factory);
    }

    @Override
    public List<Employee> getAll() {
        return query("Employee.GetAll", identity());
    }
}
