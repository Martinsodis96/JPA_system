package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.BaseRepository;

import java.util.List;

/**
 * Created by Martin on 2016-10-20.
 */
public final class DepartmentRepository extends BaseRepository<Department> {

    @Override
    public void create(Department department) throws RepositoryException {
        super.create(department);
    }

    @Override
    public Department read(Long id) throws RepositoryException {
        return super.read(id);
    }

    @Override
    public void update(Department department) {
        super.update(department);
    }

    @Override
    public void changeStatus(Department department) {
        super.changeStatus(department);
    }

    @Override
    public List<Department> getAll(Class type) throws RepositoryException {
        return super.getAll(type);
    }
}
