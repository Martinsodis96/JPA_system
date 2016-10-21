package se.soderstrand.martin.service;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.EmployeeRepository;

public final class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void saveDepartment(Department department) throws ServiceException {
        try {
            departmentRepository.create(department);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to save department with id: " + department.getId());
        }
    }

    public Department getDepartment(Long id) throws ServiceException{
        try {
            return departmentRepository.read(id, Department.class);
        } catch (RepositoryException e) {
            e.printStackTrace();
            throw new ServiceException("Failed to save department with id: ");
        }
    }
}
