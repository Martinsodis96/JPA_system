package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.BaseRepository;

import java.util.List;

public final class EmployeeRepository extends BaseRepository<Employee> {

    @Override
    public void create(Employee employee) throws RepositoryException {
        super.create(employee);
    }

    @Override
    public Employee read(Long id, Class type) throws RepositoryException {
        return super.read(id, type);
    }

    @Override
    public void update(Employee employee) throws RepositoryException {
        super.update(employee);
    }

    @Override
    public void delete(Employee employee) throws RepositoryException {
        super.delete(employee);
    }

    @Override
    public List<Employee> getAll(Class type) throws RepositoryException {
        return super.getAll(type);
    }
}