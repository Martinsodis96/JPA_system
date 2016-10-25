package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee> {

    List<Employee> getAll() throws RepositoryException;

}