package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.BaseRepository;
import se.soderstrand.martin.repository.crud.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department> {

    List<Department> getAll() throws RepositoryException;

}
