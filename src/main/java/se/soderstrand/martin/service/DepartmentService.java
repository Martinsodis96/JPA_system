package se.soderstrand.martin.service;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.EmployeeRepository;

import java.util.List;

public final class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void storeDepartment(Department department) throws ServiceException {
        try {
            departmentRepository.saveOrUpdate(department);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to save department with id: " + department.getId());
        }
    }

    public Department getDepartmentById(Long id) throws ServiceException{
        try {
            return departmentRepository.findById(id);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to save department with id: " + id);
        }
    }

    public void deleteDepartment(Department department) throws ServiceException {
        try {
            departmentRepository.delete(department);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to delete department with id: " + department.getId());
        }
    }


    public List<Department> getAllDepartments() throws ServiceException {
        try {
            return departmentRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get all departments");
        }
    }
}
