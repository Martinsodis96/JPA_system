package se.soderstrand.martin.service;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;

public final class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department storeDepartment(Department department) throws ServiceException {
        try {
            return departmentRepository.saveOrUpdate(department);
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

    public Department deleteDepartment(Department department) throws ServiceException {
        try {
            return departmentRepository.delete(department);
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

    public Collection<Employee> getEmployeesFromDepartment(Long id) throws ServiceException {
        try {
            Department department = departmentRepository.findById(id);
            return department.getEmployees();
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get all employees fro department with id: " + id);
        }
    }
}
