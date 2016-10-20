package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.BaseRepository;

import java.util.List;

/**
 * Created by Martin on 2016-10-20.
 */
public final class EmployeeRepository extends BaseRepository<Employee> {

    @Override
    public void create(Employee employee) throws RepositoryException {
        super.create(employee);
    }

    @Override
    public Employee read(Long id) throws RepositoryException {
        return super.read(id);
    }

    @Override
    public void update(Employee employee) {
        super.update(employee);
    }

    @Override
    public void changeStatus(Employee employee) {
        super.changeStatus(employee);
    }

    @Override
    public List<Employee> getAll(Class type) throws RepositoryException {
        return super.getAll(type);
    }
}