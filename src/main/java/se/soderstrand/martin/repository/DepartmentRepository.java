package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.BaseRepository;

import java.util.List;

public final class DepartmentRepository extends BaseRepository<Department> {

    @Override
    public void create(Department department) throws RepositoryException {
        super.create(department);
    }

    @Override
    public Department read(Long id, Class<Department> department) throws RepositoryException {
        return super.read(id, department);
    }

    @Override
    public void update(Department department) throws RepositoryException {
        super.update(department);
    }

    @Override
    public void delete(Department department) throws RepositoryException {
        super.delete(department);
    }

    @Override
    public List<Department> getAll(Class type) throws RepositoryException {
        return super.getAll(type);
    }
}
