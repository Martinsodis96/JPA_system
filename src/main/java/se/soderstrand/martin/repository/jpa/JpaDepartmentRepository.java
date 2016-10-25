package se.soderstrand.martin.repository.jpa;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.crud.BaseRepository;
import se.soderstrand.martin.repository.crud.CrudRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Martin on 2016-10-25.
 */
public final class JpaDepartmentRepository extends BaseRepository<Department>
        implements DepartmentRepository {

    public JpaDepartmentRepository(EntityManagerFactory factory) {
        super(Department.class, factory);
    }

    @Override
    public List<Department> getAll() {
        return null;
    }
}

