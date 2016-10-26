package se.soderstrand.martin.repository.jpa;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.crud.BaseRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

import static java.util.function.UnaryOperator.identity;

public final class JpaDepartmentRepository extends BaseRepository<Department>
        implements DepartmentRepository {

    public JpaDepartmentRepository(EntityManagerFactory factory) {
        super(Department.class, factory);
    }

    @Override
    public List<Department> getAll() {
        return query("Department.GetAll", identity());
    }
}

